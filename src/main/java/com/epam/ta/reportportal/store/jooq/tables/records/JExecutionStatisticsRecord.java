/*
 * This file is generated by jOOQ.
*/
package com.epam.ta.reportportal.store.jooq.tables.records;

import com.epam.ta.reportportal.store.jooq.tables.JExecutionStatistics;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;

import javax.annotation.Generated;

/**
 * This class is generated by jOOQ.
 */
@Generated(value = { "http://www.jooq.org", "jOOQ version:3.10.5" }, comments = "This class is generated by jOOQ")
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JExecutionStatisticsRecord extends UpdatableRecordImpl<JExecutionStatisticsRecord>
		implements Record6<Long, Integer, String, Boolean, Long, Long> {

	private static final long serialVersionUID = -693483134;

	/**
	 * Setter for <code>public.execution_statistics.id</code>.
	 */
	public void setId(Long value) {
		set(0, value);
	}

	/**
	 * Getter for <code>public.execution_statistics.id</code>.
	 */
	public Long getId() {
		return (Long) get(0);
	}

	/**
	 * Setter for <code>public.execution_statistics.counter</code>.
	 */
	public void setCounter(Integer value) {
		set(1, value);
	}

	/**
	 * Getter for <code>public.execution_statistics.counter</code>.
	 */
	public Integer getCounter() {
		return (Integer) get(1);
	}

	/**
	 * Setter for <code>public.execution_statistics.status</code>.
	 */
	public void setStatus(String value) {
		set(2, value);
	}

	/**
	 * Getter for <code>public.execution_statistics.status</code>.
	 */
	public String getStatus() {
		return (String) get(2);
	}

	/**
	 * Setter for <code>public.execution_statistics.positive</code>.
	 */
	public void setPositive(Boolean value) {
		set(3, value);
	}

	/**
	 * Getter for <code>public.execution_statistics.positive</code>.
	 */
	public Boolean getPositive() {
		return (Boolean) get(3);
	}

	/**
	 * Setter for <code>public.execution_statistics.item_id</code>.
	 */
	public void setItemId(Long value) {
		set(4, value);
	}

	/**
	 * Getter for <code>public.execution_statistics.item_id</code>.
	 */
	public Long getItemId() {
		return (Long) get(4);
	}

	/**
	 * Setter for <code>public.execution_statistics.launch_id</code>.
	 */
	public void setLaunchId(Long value) {
		set(5, value);
	}

	/**
	 * Getter for <code>public.execution_statistics.launch_id</code>.
	 */
	public Long getLaunchId() {
		return (Long) get(5);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Record1<Long> key() {
		return (Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Record6 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row6<Long, Integer, String, Boolean, Long, Long> fieldsRow() {
		return (Row6) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row6<Long, Integer, String, Boolean, Long, Long> valuesRow() {
		return (Row6) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Long> field1() {
		return JExecutionStatistics.EXECUTION_STATISTICS.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field2() {
		return JExecutionStatistics.EXECUTION_STATISTICS.COUNTER;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field3() {
		return JExecutionStatistics.EXECUTION_STATISTICS.STATUS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Boolean> field4() {
		return JExecutionStatistics.EXECUTION_STATISTICS.POSITIVE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Long> field5() {
		return JExecutionStatistics.EXECUTION_STATISTICS.ITEM_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Long> field6() {
		return JExecutionStatistics.EXECUTION_STATISTICS.LAUNCH_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long component1() {
		return getId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer component2() {
		return getCounter();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String component3() {
		return getStatus();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Boolean component4() {
		return getPositive();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long component5() {
		return getItemId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long component6() {
		return getLaunchId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long value1() {
		return getId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value2() {
		return getCounter();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value3() {
		return getStatus();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Boolean value4() {
		return getPositive();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long value5() {
		return getItemId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long value6() {
		return getLaunchId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public JExecutionStatisticsRecord value1(Long value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public JExecutionStatisticsRecord value2(Integer value) {
		setCounter(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public JExecutionStatisticsRecord value3(String value) {
		setStatus(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public JExecutionStatisticsRecord value4(Boolean value) {
		setPositive(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public JExecutionStatisticsRecord value5(Long value) {
		setItemId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public JExecutionStatisticsRecord value6(Long value) {
		setLaunchId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public JExecutionStatisticsRecord values(Long value1, Integer value2, String value3, Boolean value4, Long value5, Long value6) {
		value1(value1);
		value2(value2);
		value3(value3);
		value4(value4);
		value5(value5);
		value6(value6);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached JExecutionStatisticsRecord
	 */
	public JExecutionStatisticsRecord() {
		super(JExecutionStatistics.EXECUTION_STATISTICS);
	}

	/**
	 * Create a detached, initialised JExecutionStatisticsRecord
	 */
	public JExecutionStatisticsRecord(Long id, Integer counter, String status, Boolean positive, Long itemId, Long launchId) {
		super(JExecutionStatistics.EXECUTION_STATISTICS);

		set(0, id);
		set(1, counter);
		set(2, status);
		set(3, positive);
		set(4, itemId);
		set(5, launchId);
	}
}
