package com.trsvax.tapestry.aws.core.pages.aws.ses;

import java.util.List;

import org.apache.tapestry5.annotations.BeginRender;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.DeleteVerifiedEmailAddressRequest;
import com.amazonaws.services.simpleemail.model.VerifyEmailAddressRequest;

public class ListAuth {
	@Inject
	private AmazonSimpleEmailService email;
	
	@Property
	private List<String> verifiedAddresses;
	@Property
	private String emailAddress;
	
	@Property
	private String newEmailAddress;
	
	@BeginRender
	void init() {
		verifiedAddresses = email.listVerifiedEmailAddresses().getVerifiedEmailAddresses();
	}
	
	void onSuccess() {
		VerifyEmailAddressRequest request = new VerifyEmailAddressRequest();
		request.setEmailAddress(newEmailAddress);
		email.verifyEmailAddress(request);
	}
	
	Object onActionFromDelete(String emailAddress) {
		DeleteVerifiedEmailAddressRequest request = new DeleteVerifiedEmailAddressRequest();
		request.setEmailAddress(emailAddress);
		email.deleteVerifiedEmailAddress(request);
		return null;
	}
	

}
