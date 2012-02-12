package com.trsvax.tapestry.aws.core.pages.aws.cloudwatch;

import java.util.List;

import org.apache.tapestry5.annotations.BeginRender;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.amazonaws.services.cloudwatch.AmazonCloudWatch;
import com.amazonaws.services.cloudwatch.model.Metric;

public class CloudWatchIndex {
	
	@Inject
	private AmazonCloudWatch client;
	
	@Property
	private List<Metric> metrics;
	
	
	@BeginRender
	void init() {
		metrics = client.listMetrics().getMetrics();
	}

}
