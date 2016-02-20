
//Copyright [2011] [Barry Books]

//   Licensed under the Apache License, Version 2.0 (the "License");
//   you may not use this file except in compliance with the License.
//   You may obtain a copy of the License at

//       http://www.apache.org/licenses/LICENSE-2.0

//   Unless required by applicable law or agreed to in writing, software
//   distributed under the License is distributed on an "AS IS" BASIS,
//   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//   See the License for the specific language governing permissions and
//   limitations under the License.

package com.trsvax.tapestry.aws.core.services;

import org.apache.tapestry5.ioc.ServiceBinder;
import org.apache.tapestry5.ioc.ServiceBuilder;
import org.apache.tapestry5.ioc.ServiceResources;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.services.autoscaling.AmazonAutoScaling;
import com.amazonaws.services.autoscaling.AmazonAutoScalingClient;
import com.amazonaws.services.cloudwatch.AmazonCloudWatch;
import com.amazonaws.services.cloudwatch.AmazonCloudWatchClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancing;
import com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingClient;
import com.amazonaws.services.elasticmapreduce.AmazonElasticMapReduce;
import com.amazonaws.services.elasticmapreduce.AmazonElasticMapReduceClient;
import com.amazonaws.services.identitymanagement.AmazonIdentityManagement;
import com.amazonaws.services.identitymanagement.AmazonIdentityManagementClient;
import com.amazonaws.services.rds.AmazonRDS;
import com.amazonaws.services.rds.AmazonRDSClient;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.simpledb.AmazonSimpleDB;
import com.amazonaws.services.simpledb.AmazonSimpleDBClient;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClient;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;

/**
 * This module is automatically included as part of the Tapestry IoC Registry, it's a good place to
 * configure and extend Tapestry, or to place your own service definitions.
 */
public class AWSCoreModule
{
    public static void bind(ServiceBinder binder)
    {
		//binder.bind(AWSMailTransport.class,AWSMailTransportImpl.class);
		
		binder.bind(AmazonS3.class, new ServiceBuilder<AmazonS3>() {  	   
			public AmazonS3 buildService(ServiceResources serviceResources) {
				return new AmazonS3Client( serviceResources.getService(AWSCredentials.class));
			}
		});
		binder.bind(AmazonDynamoDB.class, new ServiceBuilder<AmazonDynamoDB>() {  	   
			public AmazonDynamoDB buildService(ServiceResources serviceResources) {
				return new AmazonDynamoDBClient( serviceResources.getService(AWSCredentials.class));
			}
		});
		binder.bind(AmazonEC2.class, new ServiceBuilder<AmazonEC2>() {  	   
			public AmazonEC2 buildService(ServiceResources serviceResources) {
				return new AmazonEC2Client( serviceResources.getService(AWSCredentials.class));
			}
		});
		binder.bind(AmazonSimpleDB.class, new ServiceBuilder<AmazonSimpleDB>() {  	   
			public AmazonSimpleDB buildService(ServiceResources serviceResources) {
				return new AmazonSimpleDBClient( serviceResources.getService(AWSCredentials.class));
			}
		});
		binder.bind(AmazonSQS.class, new ServiceBuilder<AmazonSQS>() {  	   
			public AmazonSQS buildService(ServiceResources serviceResources) {
				return new AmazonSQSClient( serviceResources.getService(AWSCredentials.class));
			}
		});
		binder.bind(AmazonSNS.class, new ServiceBuilder<AmazonSNS>() {  	   
			public AmazonSNS buildService(ServiceResources serviceResources) {
				return new AmazonSNSClient( serviceResources.getService(AWSCredentials.class));
			}
		});
		binder.bind(AmazonRDS.class, new ServiceBuilder<AmazonRDS>() {  	   
			public AmazonRDS buildService(ServiceResources serviceResources) {
				return new AmazonRDSClient( serviceResources.getService(AWSCredentials.class));
			}
		});
		binder.bind(AmazonElasticMapReduce.class, new ServiceBuilder<AmazonElasticMapReduce>() {  	   
			public AmazonElasticMapReduce buildService(ServiceResources serviceResources) {
				return new AmazonElasticMapReduceClient( serviceResources.getService(AWSCredentials.class));
			}
		});
		binder.bind(AmazonSimpleEmailService.class, new ServiceBuilder<AmazonSimpleEmailService>() {  	   
			public AmazonSimpleEmailService buildService(ServiceResources serviceResources) {
				return new AmazonSimpleEmailServiceClient( serviceResources.getService(AWSCredentials.class));
			}
		});
		binder.bind(AmazonElasticLoadBalancing.class, new ServiceBuilder<AmazonElasticLoadBalancing>() {  	   
			public AmazonElasticLoadBalancing buildService(ServiceResources serviceResources) {
				return new AmazonElasticLoadBalancingClient( serviceResources.getService(AWSCredentials.class));
			}
		});
		binder.bind(AmazonCloudWatch.class, new ServiceBuilder<AmazonCloudWatch>() {  	   
			public AmazonCloudWatch buildService(ServiceResources serviceResources) {
				return new AmazonCloudWatchClient( serviceResources.getService(AWSCredentials.class));
			}
		});
		binder.bind(AmazonAutoScaling.class, new ServiceBuilder<AmazonAutoScaling>() {  	   
			public AmazonAutoScaling buildService(ServiceResources serviceResources) {
				return new AmazonAutoScalingClient( serviceResources.getService(AWSCredentials.class));
			}
		});
		binder.bind(AmazonIdentityManagement.class, new ServiceBuilder<AmazonIdentityManagement>() {  	   
			public AmazonIdentityManagement buildService(ServiceResources serviceResources) {
				return new AmazonIdentityManagementClient( serviceResources.getService(AWSCredentials.class));
			}
		});
    }
    
    
    
}
