package com.trsvax.tapestry.aws.core.pages.aws.ec2;

import java.util.List;

import org.apache.tapestry5.annotations.BeginRender;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.model.AvailabilityZone;


public class EC2Index {
	
	@Inject
	private AmazonEC2 client;
	
	@Property
	private List<AvailabilityZone> zones;
	
	@BeginRender
	void init() {
		zones = client.describeAvailabilityZones().getAvailabilityZones();
	}

}
