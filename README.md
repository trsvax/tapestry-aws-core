No Longer maintained moving to node/graphql/react
---

Tapestry service interface for the Amazon Web Services.

Currently you'll need to build from source then

add this to your POM
        <dependency>
        	<groupId>com.trsvax</groupId>
        	<artifactId>tapestry-aws-core</artifactId>
        	<version>0.0.1-SNAPSHOT</version>
        </dependency>



add this to your AppModule where the property file contains your AWS credentials
		binder.bind(AWSCredentials.class, new ServiceBuilder<AWSCredentials>() {
			public AWSCredentials buildService(ServiceResources serviceResources) {
				try {
					return new PropertiesCredentials( new File(System.getProperty("AWS-INI")));
				} catch (Exception e) {
					e.printStackTrace();
				} 
				return null;
			}
		});


Then use it

S3Index.java

public class S3Index {
	@Inject
	private AmazonS3 amazonS3;
	
	@Property
	private List<Bucket> buckets;
	
	@BeginRender
	void beginRender() {
		buckets = amazonS3.listBuckets();
	}
	

}

S3Index.tml

<t:grid t:id="buckets"/>

For more info
http://aws.amazon.com/sdkforjava/


