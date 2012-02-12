package com.trsvax.tapestry.aws.core.pages.aws.sns;

import java.util.List;

import org.apache.tapestry5.annotations.BeginRender;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.Subscription;
import com.amazonaws.services.sns.model.Topic;

public class SNSIndex {
	@Inject
	private AmazonSNS client;
	
	@Property
	private List<Topic> topics;
	@Property
	private Topic topic;
	
	@Property
	private List<Subscription> subscriptions;
	
	@BeginRender
	void init() {
		topics = client.listTopics().getTopics();
		subscriptions = client.listSubscriptions().getSubscriptions();
	}

}
