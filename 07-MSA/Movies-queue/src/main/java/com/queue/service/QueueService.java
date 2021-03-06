package com.queue.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.SendMessageRequest;

@Service("queue")
public class QueueService {

	@Autowired
	private static Environment env;
	private AWSCredentials cred;
	private AmazonSQS sqs;
	private String accessKey;
	private String secretKey;
	private String url = "";
	
	public void BuildQueue() {
		cred = new BasicAWSCredentials(accessKey, secretKey);
		sqs = AmazonSQSClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(cred))
				.withRegion(Regions.US_EAST_1).build();
	}
	
	public void sendMessage(String message) {
		SendMessageRequest send = new SendMessageRequest().withQueueUrl(url)
				.withMessageBody("this is our message: "+message);
		sqs.sendMessage(send);
	}
	
	
	public String getMessage() {
		return sqs.receiveMessage(url).getMessages().get(0).getBody();
	}
}
