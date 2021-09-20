package com.demo.virtualtopics;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.JmsListener;

@SpringBootApplication
public class Consumer1Application {

	private static final Logger LOG = LoggerFactory.getLogger(Consumer1Application.class);

	private static final String VIRTUAL_TOPIC = "Consumer.consumer1.VirtualTopic.test";

	public static void main(String[] args) {
		SpringApplication.run(Consumer1Application.class, args);
	}

	@JmsListener(destination = VIRTUAL_TOPIC)
	public void receiveMessage(final TextMessage message) throws JMSException {
		LOG.info("Consumer1 : response received : {}", message.getText());
	}
}
