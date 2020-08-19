package com.soy.demo.quartz.simple3;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig3 {

    @Bean
    public JobDetail jobDetail1(){
        System.out.println("调用了1");
        JobDetail jobDetail = JobBuilder.newJob(MyJob3.class)
                .withIdentity("name1", "group1")
                .usingJobData("data1", "value1")
                .usingJobData("name",1)
                .storeDurably()
                .build();
        JobDataMap jobDataMap = jobDetail.getJobDataMap();
        jobDataMap.put("data2", "value2");
        return jobDetail;
    }

    @Bean
    public Trigger trigger1(){
        return TriggerBuilder.newTrigger()
                .withIdentity("name1","group1")
                .forJob(jobDetail1())
                .withSchedule(CronScheduleBuilder.cronSchedule("0/1 * * * * ?"))
                .usingJobData("name","哈哈哈")
                .build();
    }


    @Bean
    public JobDetail jobDetail2(){
        System.out.println("调用了2");
        return JobBuilder.newJob(MyJob3.class)
                .withIdentity("name2","group2")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger trigger2(){
        return TriggerBuilder.newTrigger()
                .withIdentity("name2","group2")
                .forJob(jobDetail2())
                .build();
    }
}
