package com.tothenew.intellimeet;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableJpaRepositories
@EnableScheduling
@SpringBootApplication
public class IntellimeetRestApiApplication {

    static Logger log = Logger.getLogger(IntellimeetRestApiApplication.class
            .getName());

    public static void main(String[] args) {
        ApplicationContext app = SpringApplication.run(IntellimeetRestApiApplication.class, args);
//        BootStrapService bootStrapService = app.getBean(BootStrapService.class);
    }
}
