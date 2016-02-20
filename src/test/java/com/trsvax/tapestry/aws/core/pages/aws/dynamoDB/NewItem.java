package com.trsvax.tapestry.aws.core.pages.aws.dynamoDB;

import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.slf4j.Logger;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.trsvax.tapestry.aws.core.entities.Cart;

public class NewItem {
	@PageActivationContext
	@Property
	private String tableName;
		
	@Inject
	private AmazonDynamoDB client;
	
	@Property
	private Cart cart;
	
	@Inject
	private Logger logger;
	
	@Inject
	private PageRenderLinkSource linkSource;
	
	Object onSuccess() {
		DynamoDBMapper mapper = new DynamoDBMapper(client);
		mapper.save(cart);
		return linkSource.createPageRenderLinkWithContext(ListTable.class, tableName);
	}

}
