package com.global.hitss.store.domain.component;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
 
@Component
public class Consumer {
 
    @JmsListener(destination = "queue")
    public void receive(String msg) {
        System.out.println(msg);
    }
 
}