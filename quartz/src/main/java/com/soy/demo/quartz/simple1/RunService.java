package com.soy.demo.quartz.simple1;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Service;

/**
 * @author Soy
 */
@Service
public class RunService {

    public void runSample1() throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
                // 没下面没有区别
                //.withIdentity("name1","group1")
                .build();
        Trigger trigger = TriggerBuilder.newTrigger()
                // 没下面没有区别
                //.withIdentity("name1","group1")
                // 没下面的话只运行1次
                .withSchedule(CronScheduleBuilder.cronSchedule("0/1 * * * * ?"))
                .build();
        // StdSchedulerFactory sf = new StdSchedulerFactory();
        // Scheduler scheduler = sf.getScheduler();
        // 上面的2个语句等同下面的一个
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.scheduleJob(jobDetail, trigger);
        // 没下面的话不会执行
        scheduler.start();
    }
}
