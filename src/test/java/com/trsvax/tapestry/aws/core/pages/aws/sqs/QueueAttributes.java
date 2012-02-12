package com.trsvax.tapestry.aws.core.pages.aws.sqs;

import java.util.Map;
import java.util.Set;

import org.apache.tapestry5.annotations.BeginRender;
import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.GetQueueAttributesRequest;

public class QueueAttributes {
	
	@Inject
	private AmazonSQS client;
	
	@PageActivationContext
	private String queueUrl;
	
	private Map<String, String> attributes;
	@Property
	private String key;
	
	@BeginRender
	void init() {
		attributes = client.getQueueAttributes(new GetQueueAttributesRequest(queueUrl)).getAttributes();
	}
	
	public Set<String> getKeys() {
		return attributes.keySet();
	}
	
	public String getValue() {
		return attributes.get(key);
	}

}
