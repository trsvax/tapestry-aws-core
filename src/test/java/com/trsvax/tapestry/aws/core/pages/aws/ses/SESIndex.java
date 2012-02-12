package com.trsvax.tapestry.aws.core.pages.aws.ses;

import org.apache.tapestry5.annotations.BeginRender;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.GetSendQuotaResult;
import com.amazonaws.services.simpleemail.model.GetSendStatisticsResult;

public class SESIndex {
	
	@Inject
	private AmazonSimpleEmailService emailService;
	
	@Property
	private GetSendQuotaResult sendQuota;
	@Property
	private GetSendStatisticsResult sendStatistics;

	
	@BeginRender
	void init() {
		sendQuota = emailService.getSendQuota();
		sendStatistics = emailService.getSendStatistics();
	}
}
