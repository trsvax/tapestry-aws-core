package com.trsvax.tapestry.aws.core.pages.aws.simpleDB;

import java.util.List;

import org.apache.tapestry5.annotations.BeginRender;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.amazonaws.services.simpledb.AmazonSimpleDB;

public class SimpleDBIndex {
	
	@Inject
	private AmazonSimpleDB client;
	
	@Property
	private List<String> domains;
	@Property
	private String domain;
	
	@BeginRender
	void init() {
		domains = client.listDomains().getDomainNames();
	}

}
