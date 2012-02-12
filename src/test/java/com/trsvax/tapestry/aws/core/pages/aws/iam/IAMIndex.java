package com.trsvax.tapestry.aws.core.pages.aws.iam;

import java.util.List;

import org.apache.tapestry5.annotations.BeginRender;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.amazonaws.services.identitymanagement.AmazonIdentityManagement;
import com.amazonaws.services.identitymanagement.AmazonIdentityManagementClient;
import com.amazonaws.services.identitymanagement.model.AccessKeyMetadata;
import com.amazonaws.services.identitymanagement.model.ListUsersResult;
import com.amazonaws.services.identitymanagement.model.User;

public class IAMIndex {
	
	@Inject
	private AmazonIdentityManagement client;
	
	@Property
	private List<User> users;
	@Property
	private List<AccessKeyMetadata> keys;
	
	@BeginRender
	void init() {
		users = client.listUsers().getUsers();
		keys = client.listAccessKeys().getAccessKeyMetadata();
	}

}
