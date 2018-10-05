/*
 * Copyright 2018 EPAM Systems
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.epam.ta.reportportal.core.configs;

//@Configuration
//@EnableConfigurationProperties(SchedulerConfiguration.QuartzProperties.class)
public class SchedulerConfiguration {

	//	@Autowired
	//	List<Trigger> listOfTrigger;
	//
	//	@Autowired
	//	private QuartzProperties quartzProperties;
	//
	//	@Autowired
	//	private AutowireCapableBeanFactory context;
	//
	//	@Bean
	//	@Primary
	//	public SchedulerFactoryBean schedulerFactoryBean() {
	//		SchedulerFactoryBean scheduler = new SchedulerFactoryBean();
	//		scheduler.setApplicationContextSchedulerContextKey("applicationContext");
	//
	//		scheduler.setQuartzProperties(quartzProperties.getQuartz());
	//		scheduler.setAutoStartup(true);  // to not automatically start after startup
	//		scheduler.setWaitForJobsToCompleteOnShutdown(true);
	//		scheduler.setJobFactory(beanJobFactory());
	//
	//		// Here we will set all the trigger beans we have defined.
	//		if (null != listOfTrigger && !listOfTrigger.isEmpty()) {
	//			scheduler.setTriggers(listOfTrigger.toArray(new Trigger[listOfTrigger.size()]));
	//		}
	//
	//		return scheduler;
	//	}
	//
	//	@Bean
	//	public SpringBeanJobFactory beanJobFactory() {
	//		return new SpringBeanJobFactory() {
	//			@Override
	//			protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
	//				final Object jobInstance = super.createJobInstance(bundle);
	//				context.autowireBean(jobInstance);
	//				return jobInstance;
	//			}
	//		};
	//	}
	//
	////	@Bean
	////	public SimpleTriggerFactoryBean createCleanLogsTrigger(@Named("cleanLogsJob") JobDetail jobDetail,
	////			@Value("${com.ta.reportportal.job.clean.logs.cron}") String cleanLogsCron) {
	////		return createTrigger(jobDetail, Duration.parse(cleanLogsCron).toMillis());
	////	}
	////
	////	@Bean
	////	public SimpleTriggerFactoryBean interruptLaunchesTrigger(@Autowired @Named("interruptLaunchesJob") JobDetail jobDetail,
	////			@Value("${com.ta.reportportal.job.interrupt.broken.launches.cron}") String interruptLaunchesCron) {
	////		return createTrigger(jobDetail, Duration.parse(interruptLaunchesCron).toMillis());
	////	}
	////
	////	@Bean
	////	public SimpleTriggerFactoryBean cleanScreenshotsTrigger(@Named("cleanScreenshotsJob") JobDetail jobDetail,
	////			@Value("${com.ta.reportportal.job.clean.screenshots.cron}") String cleanScreenshotsCron) {
	////		return createTrigger(jobDetail, Duration.parse(cleanScreenshotsCron).toMillis());
	////	}
	//
	////	@Bean
	////	@Named("cleanLogsJob")
	////	public static JobDetailFactoryBean cleanLogsJob() {
	////		return createJobDetail(CleanLogsJob.class);
	////	}
	////
	////	@Bean
	////	@Named("interruptLaunchesJob")
	////	public static JobDetailFactoryBean interruptLaunchesJob() {
	////		return createJobDetail(InterruptBrokenLaunchesJob.class);
	////	}
	////
	////	@Bean
	////	@Named("cleanScreenshotsJob")
	////	public static JobDetailFactoryBean cleanScreenshotsJob() {
	////		return createJobDetail(CleanScreenshotsJob.class);
	////	}
	//
	//	public static SimpleTriggerFactoryBean createTrigger(JobDetail jobDetail, long pollFrequencyMs) {
	//		SimpleTriggerFactoryBean factoryBean = new SimpleTriggerFactoryBean();
	//		factoryBean.setJobDetail(jobDetail);
	//		factoryBean.setStartDelay(0L);
	//		factoryBean.setRepeatInterval(pollFrequencyMs);
	//		factoryBean.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
	//		// in case of misfire, ignore all missed triggers and continue :
	//		factoryBean.setMisfireInstruction(SimpleTrigger.MISFIRE_INSTRUCTION_RESCHEDULE_NEXT_WITH_REMAINING_COUNT);
	//		return factoryBean;
	//	}
	//
	//	// Use this method for creating cron triggers instead of simple triggers:
	//	public static CronTriggerFactoryBean createCronTrigger(JobDetail jobDetail, String cronExpression) {
	//		CronTriggerFactoryBean factoryBean = new CronTriggerFactoryBean();
	//		factoryBean.setJobDetail(jobDetail);
	//		factoryBean.setCronExpression(cronExpression);
	//		factoryBean.setMisfireInstruction(SimpleTrigger.MISFIRE_INSTRUCTION_FIRE_NOW);
	//		return factoryBean;
	//	}
	//
	//	public static JobDetailFactoryBean createJobDetail(Class jobClass) {
	//		JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
	//		factoryBean.setJobClass(jobClass);
	//		// job has to be durable to be stored in DB:
	//		factoryBean.setDurability(true);
	//		return factoryBean;
	//	}
	//
	//	@ConfigurationProperties("spring")
	//	public class QuartzProperties {
	//
	//		private final Properties quartz = new Properties();
	//
	//		public Properties getQuartz() {
	//			return quartz;
	//		}
	//
	//	}

}
