package com.trsvax.tapestry.aws.core.pages.aws.dynamoDB;

import java.util.List;

import org.apache.tapestry5.annotations.BeginRender;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.amazonaws.services.dynamodb.AmazonDynamoDB;

public class DynamoDBIndex {
	
	@Inject
	private AmazonDynamoDB client;
	
	@Property
	private List<String> tables;
	
	@Property
	private String table;
	
	@BeginRender
	void init() {
		tables = client.listTables().getTableNames();
	}
	
	

}
