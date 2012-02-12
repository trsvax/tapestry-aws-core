package com.trsvax.tapestry.aws.core.entities;

import com.amazonaws.services.dynamodb.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodb.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodb.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodb.datamodeling.DynamoDBVersionAttribute;

@DynamoDBTable(tableName = "Cart")
public class Cart {
    private Long key;
    private Long version;

    private String itemName;
    

	
	
	@DynamoDBAttribute(attributeName = "itemName")
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	

	
    
    @DynamoDBVersionAttribute
    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
    
    @DynamoDBHashKey(attributeName="key")
	public Long getKey() {
		return key;
	}
	public void setKey(Long key) {
		this.key = key;
	}
    

}
