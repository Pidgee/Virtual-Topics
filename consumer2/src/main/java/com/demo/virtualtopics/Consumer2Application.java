package com.demo.virtualtopics;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.JmsListener;

@SpringBootApplication
public class Consumer2Application {

	private static final Logger LOG = LoggerFactory.getLogger(Consumer2Application.class);

	private static final String VIRTUAL_TOPIC = "Consumer.consumer2.VirtualTopic.test";
	
	public static void main(String[] args) {
		SpringApplication.run(Consumer2Application.class, args);
	}

	@JmsListener(destination = VIRTUAL_TOPIC)
	public void receiveMessage(final TextMessage message) throws JMSException {
		LOG.info("Consumer2 : response received : {}", message.getText());
	}
	
	@JmsListener(destination = VIRTUAL_TOPIC)
	public void receiveMessage2(final TextMessage message) throws JMSException {
		LOG.info("Another Consumer2 : response received : {}", message.getText());
	}
}
