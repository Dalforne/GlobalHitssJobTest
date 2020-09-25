package com.global.hitss.store.config;




import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;

import com.global.hitss.store.domain.component.Consumer;


@SpringBootApplication
@ComponentScan(basePackageClasses = {Consumer.class})
@EnableJms
public class AppConfig {
 
//    public static void main(String[] args) {
//        ApplicationContext ctx = SpringApplication.run(AppConfig.class, args);
//    }
    @Bean
    public Queue queue() {
        return new ActiveMQQueue("queue");
    }
}
