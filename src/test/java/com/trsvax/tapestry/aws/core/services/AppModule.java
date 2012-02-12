package com.trsvax.tapestry.aws.core.services;

import java.io.File;

import org.apache.tapestry5.ioc.ServiceBinder;
import org.apache.tapestry5.ioc.ServiceBuilder;
import org.apache.tapestry5.ioc.ServiceResources;
import org.apache.tapestry5.ioc.annotations.SubModule;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.PropertiesCredentials;

@SubModule(AWSCoreModule.class)
public class AppModule {
	
	public static void bind(ServiceBinder binder)
	{

		binder.bind(AWSCredentials.class, new ServiceBuilder<AWSCredentials>() {
			public AWSCredentials buildService(ServiceResources serviceResources) {
				try {
					return new PropertiesCredentials( new File(System.getenv("AWS_INI")));
				} catch (Exception e) {
					e.printStackTrace();
				} 
				return null;
			}
		}).eagerLoad();
	}

}
