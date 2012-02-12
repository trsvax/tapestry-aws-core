package com.trsvax.tapestry.aws.core.pages.aws.elb;

import java.util.List;

import org.apache.tapestry5.annotations.BeginRender;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancing;
import com.amazonaws.services.elasticloadbalancing.model.LoadBalancerDescription;

public class ELBIndex {
	@Inject
	private AmazonElasticLoadBalancing client;
	
	@Property
	private List<LoadBalancerDescription> descriptions;
	
	@BeginRender
	void init() {
		descriptions = client.describeLoadBalancers().getLoadBalancerDescriptions();
	}
	

}
