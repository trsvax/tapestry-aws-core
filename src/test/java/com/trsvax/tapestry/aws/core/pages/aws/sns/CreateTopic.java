package com.trsvax.tapestry.aws.core.pages.aws.sns;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.CreateTopicRequest;

public class CreateTopic {
	@Inject
	private AmazonSNS client;
	
	@Property
	private String name;
	
	Object onSuccess() {
		client.createTopic( new CreateTopicRequest(name));
		return SNSIndex.class;
	}

}
