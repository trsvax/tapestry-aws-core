package com.trsvax.tapestry.aws.core.pages.aws.sqs;

import java.util.List;

import org.apache.tapestry5.annotations.BeginRender;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;

public class SQSIndex {
	
	@Inject
	private AmazonSQS client;
	
	@Property
	private List<String> urls;
	@Property
	private String url;
	
	@BeginRender
	void init() {
		urls = client.listQueues().getQueueUrls();
	}

}
