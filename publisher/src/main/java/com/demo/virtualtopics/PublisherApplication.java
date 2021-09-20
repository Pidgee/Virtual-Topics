package com.demo.virtualtopics;

import org.apache.activemq.command.ActiveMQTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@SpringBootApplication
public class PublisherApplication {

	private static final Logger LOG = LoggerFactory.getLogger(PublisherApplication.class);

	@Autowired
	private JmsTemplate jmsTemplate;
	private int messageNo = 1;

	public static void main(String[] args) {
		SpringApplication.run(PublisherApplication.class, args);
	}

	@Scheduled(fixedRate = 10000)
	public void publish() {
		LOG.info("Sending a message!");
		jmsTemplate.convertAndSend(new ActiveMQTopic("VirtualTopic.test"), "Hello World! number " + messageNo);
		messageNo++;
	}
}
