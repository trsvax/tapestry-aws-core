package com.trsvax.tapestry.aws.core.pages.aws.sqs;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.CreateQueueRequest;

public class CreateQueue {
	@Inject
	private AmazonSQS client;
	
	@Property
	private String queueName;
	
	Object onSuccess() {
		client.createQueue( new CreateQueueRequest(queueName));
		return SQSIndex.class;
	}

}
