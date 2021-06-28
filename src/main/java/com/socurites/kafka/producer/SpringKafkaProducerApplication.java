package com.socurites.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaProducerException;
import org.springframework.kafka.core.KafkaSendCallback;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

@SpringBootApplication
public class SpringKafkaProducerApplication implements CommandLineRunner {
	private static final String TOPIC_NAME = "test";
	
//	@Autowired
//	private KafkaTemplate<Integer, String> template;
	
	@Autowired
	private KafkaTemplate<String, String> customKafkaTemplate;

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(SpringKafkaProducerApplication.class);
		application.run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		ListenableFuture<SendResult<String, String>> future = customKafkaTemplate.send(TOPIC_NAME, "messageValue");
		future.addCallback(new KafkaSendCallback<String, String>() {

			@Override
			public void onSuccess(SendResult<String, String> result) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onFailure(Throwable ex) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onFailure(KafkaProducerException ex) {
				// TODO Auto-generated method stub
				
			}
		});
		
		System.exit(0);
	}

}