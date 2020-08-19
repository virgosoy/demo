package com.soy.demo.quartz.simple3;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import java.util.Arrays;

@Slf4j
public class MyJob3 extends QuartzJobBean {

    @Setter
    private String[] name;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println("MyJob run in SpringBoot demo, name = " + Arrays.toString(name));
        JobDetail jobDetail = context.getJobDetail();
        JobDataMap jobDataMap = jobDetail.getJobDataMap();
        JobKey jobKey = jobDetail.getKey();
        System.out.println(jobKey); // group.name
        jobDataMap.forEach((key, value) -> {
            System.out.println(key + ": " + value);
        });
    }


}
