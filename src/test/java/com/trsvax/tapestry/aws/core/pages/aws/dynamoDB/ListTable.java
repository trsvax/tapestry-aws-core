package com.trsvax.tapestry.aws.core.pages.aws.dynamoDB;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.tapestry5.annotations.BeginRender;
import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;




public class ListTable {
	@PageActivationContext
	@Property
	private String tableName;
	
	@Inject
	private AmazonDynamoDB client;
	
	@Property
	private List<Map<String,AttributeValue>> items;
	
	@Property
	private Map<String,AttributeValue> item;
	
	@Property
	private String key;
	
	@BeginRender
	void init() {
		items = client.scan(new ScanRequest(tableName)).getItems();
	}
	
	public Set<String> getKeys() {
		return item.keySet();
	}
	
	public String getValue() {
		if ( item.get(key).getN() != null) {
			return item.get(key).getN();
		}
		return item.get(key).getS();
	}

}
