package com.trsvax.tapestry.aws.core.pages.aws.s3;

import java.util.List;

import org.apache.tapestry5.annotations.BeginRender;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;

public class S3Index {
	@Inject
	private AmazonS3 amazonS3;
	
	@Property
	private List<Bucket> buckets;
	
	@BeginRender
	void init() {
		buckets = amazonS3.listBuckets();
	}
	

}
