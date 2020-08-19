package com.soy.demo.quartz.simple1;

import org.junit.jupiter.api.Test;
import org.quartz.SchedulerException;

class RunServiceTest {

    @Test
    void run() throws SchedulerException {
        new RunService().runSample1();
    }
}