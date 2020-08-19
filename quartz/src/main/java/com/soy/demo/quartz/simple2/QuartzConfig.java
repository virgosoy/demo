package com.soy.demo.quartz.simple2;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail jobDetail(){
        System.out.println("调用了");
        return JobBuilder.newJob(MyJob.class)
                /* 必须要，否则报错
                org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'quartzScheduler' defined in class path resource [org/springframework/boot/autoconfigure/quartz/QuartzAutoConfiguration.class]: Invocation of init method failed; nested exception is org.quartz.SchedulerException: Jobs added with no trigger must be durable.
                Caused by: org.quartz.SchedulerException: Jobs added with no trigger must be durable.*/
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger trigger(){
        return TriggerBuilder.newTrigger()
                /* 必须要，否则报错
                org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'quartzScheduler' defined in class path resource [org/springframework/boot/autoconfigure/quartz/QuartzAutoConfiguration.class]: Invocation of init method failed; nested exception is org.quartz.SchedulerException: Trigger's related Job's name cannot be null
                Caused by: org.quartz.SchedulerException: Trigger's related Job's name cannot be null*/
                .forJob(jobDetail())
                .build();
    }


}
