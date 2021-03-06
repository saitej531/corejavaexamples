package com.dxctraining.jmsexperiment1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SenderUtility {

    @Autowired
    private JmsTemplate template;

    @PostConstruct
    public void send(){
        SimpleMessage ankitMsg = new SimpleMessage("ankit","madhya pradesh", "hello ankit");
        SimpleMessage anujMsg = new SimpleMessage("anuj","madhya pradesh" ,"hello anuj");
        SimpleMessage vineelMsg = new SimpleMessage("vineel","telangana" ,"hello vineel");

        template.setPubSubDomain(true);
        template.convertAndSend("topic.mp", ankitMsg);
        System.out.println("************sent message to ankit");
        template.convertAndSend("topic.mp", anujMsg);
        System.out.println("************sent message to anuj");
        template.convertAndSend("topic.telangana", vineelMsg);
        System.out.println("************sent message to vineel");


    }
}
