package com.soy.demo.quartz;

import com.soy.demo.quartz.simple1.RunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuartzApplication implements ApplicationRunner {

    @Autowired
    private RunService runService;

    public static void main(String[] args) {
        SpringApplication.run(QuartzApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        runService.runSample1();
    }
}
