package com.trsvax.tapestry.aws.core.pages.aws.sns;

import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.SubscribeRequest;

public class CreateSubscription {
	@Inject
	private AmazonSNS client;
	
	@PageActivationContext
	private String topicArn;
	
	@Property
	private String protocol;
	
	@Property
	private String endpoint;
	

	Object onSuccess() {
		client.subscribe(new SubscribeRequest(topicArn, protocol, endpoint));
		return SNSIndex.class;
	}
}
