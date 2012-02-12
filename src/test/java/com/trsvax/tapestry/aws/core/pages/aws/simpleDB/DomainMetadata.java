package com.trsvax.tapestry.aws.core.pages.aws.simpleDB;

import org.apache.tapestry5.annotations.BeginRender;
import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.amazonaws.services.simpledb.AmazonSimpleDB;
import com.amazonaws.services.simpledb.model.DomainMetadataRequest;
import com.amazonaws.services.simpledb.model.DomainMetadataResult;

public class DomainMetadata {
	
	@Inject
	private AmazonSimpleDB client;
	
	@Property
	private DomainMetadataResult metaData;
	
	@Property
	@PageActivationContext
	private String domainName;
	
	
	@BeginRender
	void init() {
		metaData = client.domainMetadata(new DomainMetadataRequest(domainName));
	}
	

}
