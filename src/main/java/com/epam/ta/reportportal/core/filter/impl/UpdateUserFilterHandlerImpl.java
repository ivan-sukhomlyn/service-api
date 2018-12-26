/*
 * Copyright 2018 EPAM Systems
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.epam.ta.reportportal.core.filter.impl;

import com.epam.ta.reportportal.auth.ReportPortalUser;
import com.epam.ta.reportportal.auth.acl.ShareableObjectsHandler;
import com.epam.ta.reportportal.commons.querygen.FilterTarget;
import com.epam.ta.reportportal.commons.validation.BusinessRule;
import com.epam.ta.reportportal.core.events.MessageBus;
import com.epam.ta.reportportal.core.events.activity.FilterCreatedEvent;
import com.epam.ta.reportportal.core.events.activity.FilterUpdatedEvent;
import com.epam.ta.reportportal.core.filter.GetUserFilterHandler;
import com.epam.ta.reportportal.core.filter.UpdateUserFilterHandler;
import com.epam.ta.reportportal.dao.UserFilterRepository;
import com.epam.ta.reportportal.entity.filter.ObjectType;
import com.epam.ta.reportportal.entity.filter.UserFilter;
import com.epam.ta.reportportal.ws.converter.builders.UserFilterBuilder;
import com.epam.ta.reportportal.ws.model.CollectionsRQ;
import com.epam.ta.reportportal.ws.model.EntryCreatedRS;
import com.epam.ta.reportportal.ws.model.ErrorType;
import com.epam.ta.reportportal.ws.model.OperationCompletionRS;
import com.epam.ta.reportportal.ws.model.activity.UserFilterActivityResource;
import com.epam.ta.reportportal.ws.model.filter.BulkUpdateFilterRQ;
import com.epam.ta.reportportal.ws.model.filter.UpdateUserFilterRQ;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import static com.epam.ta.reportportal.commons.Preconditions.NOT_EMPTY_COLLECTION;
import static com.epam.ta.reportportal.commons.validation.BusinessRule.expect;
import static com.epam.ta.reportportal.util.ProjectExtractor.extractProjectDetails;
import static com.epam.ta.reportportal.ws.converter.converters.UserFilterConverter.TO_ACTIVITY_RESOURCE;
import static com.epam.ta.reportportal.ws.model.ErrorType.USER_FILTER_NOT_FOUND;

@Service
public class UpdateUserFilterHandlerImpl implements UpdateUserFilterHandler {

	private final GetUserFilterHandler getUserFilterHandler;

	private final UserFilterRepository userFilterRepository;

	private final ShareableObjectsHandler aclHandler;

	private final MessageBus messageBus;

	@Autowired
	public UpdateUserFilterHandlerImpl(GetUserFilterHandler getUserFilterHandler, UserFilterRepository userFilterRepository,
			ShareableObjectsHandler aclHandler, MessageBus messageBus) {
		this.getUserFilterHandler = getUserFilterHandler;
		this.userFilterRepository = userFilterRepository;
		this.aclHandler = aclHandler;
		this.messageBus = messageBus;
	}

	@Override
	public EntryCreatedRS createFilter(UpdateUserFilterRQ createFilterRQ, String projectName, ReportPortalUser user) {
		ReportPortalUser.ProjectDetails projectDetails = extractProjectDetails(user, projectName);

		validateFilterRq(createFilterRQ);

		BusinessRule.expect(userFilterRepository.existsByNameAndOwnerAndProjectId(createFilterRQ.getName(),
				user.getUsername(),
				projectDetails.getProjectId()
		), BooleanUtils::isFalse)
				.verify(ErrorType.USER_FILTER_ALREADY_EXISTS, createFilterRQ.getName(), user.getUsername(), projectName);

		UserFilter filter = new UserFilterBuilder().addFilterRq(createFilterRQ)
				.addProject(projectDetails.getProjectId())
				.addOwner(user.getUsername())
				.get();
		userFilterRepository.save(filter);
		aclHandler.initAcl(filter, user.getUsername(), projectDetails.getProjectId(), BooleanUtils.isTrue(createFilterRQ.getShare()));
		messageBus.publishActivity(new FilterCreatedEvent(TO_ACTIVITY_RESOURCE.apply(filter), user.getUserId()));
		return new EntryCreatedRS(filter.getId());
	}

	@Override
	public OperationCompletionRS updateUserFilter(Long userFilterId, UpdateUserFilterRQ updateRQ,
			ReportPortalUser.ProjectDetails projectDetails, ReportPortalUser user) {
		validateFilterRq(updateRQ);
		UserFilter userFilter = getUserFilterHandler.getFilter(userFilterId, projectDetails, user);
		expect(userFilter.getProject().getId(), Predicate.isEqual(projectDetails.getProjectId())).verify(USER_FILTER_NOT_FOUND,
				userFilterId,
				projectDetails.getProjectId(),
				user.getUserId()
		);
		UserFilterActivityResource before = TO_ACTIVITY_RESOURCE.apply(userFilter);
		UserFilter updated = new UserFilterBuilder(userFilter).addFilterRq(updateRQ).get();

		if (before.isShared() != updated.isShared()) {
			aclHandler.updateAcl(updated, projectDetails.getProjectId(), updated.isShared());
		}

		messageBus.publishActivity(new FilterUpdatedEvent(before, TO_ACTIVITY_RESOURCE.apply(updated), user.getUserId()));
		return new OperationCompletionRS("User filter with ID = '" + updated.getId() + "' successfully updated.");
	}

	@Override
	public List<OperationCompletionRS> updateUserFilter(CollectionsRQ<BulkUpdateFilterRQ> updateRQ,
			ReportPortalUser.ProjectDetails projectDetails, ReportPortalUser user) {
		throw new UnsupportedOperationException("Not implemented");
	}

	/**
	 * Validation of update filter rq
	 *
	 * @param updateFilerRq Request
	 */
	private void validateFilterRq(UpdateUserFilterRQ updateFilerRq) {

		FilterTarget filterTarget = FilterTarget.findByClass(ObjectType.getObjectTypeByName(updateFilerRq.getObjectType())
				.getClassObject());

		BusinessRule.expect(updateFilerRq.getConditions(), NOT_EMPTY_COLLECTION)
				.verify(ErrorType.BAD_REQUEST_ERROR, "Filter conditions should not be empty");

		BusinessRule.expect(updateFilerRq.getOrders(), NOT_EMPTY_COLLECTION)
				.verify(ErrorType.BAD_REQUEST_ERROR, "Sort conditions should not be empty");

		//filter conditions validation
		updateFilerRq.getConditions()
				.forEach(filter -> BusinessRule.expect(filterTarget.getCriteriaByFilter(filter.getFilteringField()), Optional::isPresent)
						.verify(ErrorType.INCORRECT_FILTER_PARAMETERS, filter.getFilteringField()));
		//order conditions validation
		updateFilerRq.getOrders()
				.forEach(order -> BusinessRule.expect(filterTarget.getCriteriaByFilter(order.getSortingColumnName()), Optional::isPresent)
						.verify(ErrorType.INCORRECT_SORTING_PARAMETERS, order.getSortingColumnName()));
	}
}
