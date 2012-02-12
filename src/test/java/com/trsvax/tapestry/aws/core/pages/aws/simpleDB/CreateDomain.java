package com.trsvax.tapestry.aws.core.pages.aws.simpleDB;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.amazonaws.services.simpledb.AmazonSimpleDB;
import com.amazonaws.services.simpledb.model.CreateDomainRequest;

public class CreateDomain {
	
	@Inject
	private AmazonSimpleDB client;
	
	@Property
	private String domainName;
	
	Object onSuccess() {
		client.createDomain( new CreateDomainRequest(domainName));
		return SimpleDBIndex.class;
	}

}
