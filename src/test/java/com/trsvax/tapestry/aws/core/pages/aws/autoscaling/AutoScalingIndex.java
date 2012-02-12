package com.trsvax.tapestry.aws.core.pages.aws.autoscaling;

import java.util.List;

import org.apache.tapestry5.annotations.BeginRender;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.amazonaws.services.autoscaling.AmazonAutoScaling;
import com.amazonaws.services.autoscaling.model.AutoScalingGroup;

public class AutoScalingIndex {
	@Inject
	private AmazonAutoScaling client;
	
	@Property
	private List<AutoScalingGroup> groups;
	
	
	@BeginRender
	void init() {
		 groups = client.describeAutoScalingGroups().getAutoScalingGroups();
	}

}
