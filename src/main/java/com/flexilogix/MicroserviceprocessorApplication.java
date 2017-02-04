package com.flexilogix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

@SpringBootApplication
@EnableBinding(Processor.class)
public class MicroserviceprocessorApplication {

	private final int VERSION=100;
	private static Logger logger = LoggerFactory.getLogger(MicroserviceprocessorApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(MicroserviceprocessorApplication.class, args);
	}
	
	/*
	 * Requirement: receive the message from topic queue
	 */
	@StreamListener(Processor.INPUT)
	@SendTo(Processor.OUTPUT)
	public Data processData(Data receivedData) {
		logger.info("Received at DataProcessor: ProcessorId:" + receivedData.toString());
		
		// Change data
		receivedData.setLabel(this.VERSION+"");
		
		// Send to final topic queue
		return receivedData;
	}
}
