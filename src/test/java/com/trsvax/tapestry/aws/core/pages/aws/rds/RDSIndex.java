package com.trsvax.tapestry.aws.core.pages.aws.rds;

import java.util.List;

import org.apache.tapestry5.annotations.BeginRender;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.amazonaws.services.rds.AmazonRDS;
import com.amazonaws.services.rds.model.DBEngineVersion;

public class RDSIndex {
	@Inject
	private AmazonRDS client;
	
	@Property
	private List<DBEngineVersion> versions;
	
	
	@BeginRender
	void init() {
		versions = client.describeDBEngineVersions().getDBEngineVersions();
	}

}
