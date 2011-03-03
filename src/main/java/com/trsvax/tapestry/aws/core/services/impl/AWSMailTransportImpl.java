
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

package com.trsvax.tapestry.aws.core.services.impl;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.services.simpleemail.AWSJavaMailTransport;
import com.trsvax.tapestry.aws.core.services.AWSMailTransport;

public class AWSMailTransportImpl implements AWSMailTransport {
	private final Session session;
	private final Transport transport;

	public AWSMailTransportImpl(AWSCredentials awsCredentials) {
		this.session = session(awsCredentials);
		this.transport = new AWSJavaMailTransport(session, null);
	}
		
	public Message mimeMessage() {
		return new MimeMessage(session);
	}
	
	public void send(Message message) throws MessagingException {
		message.saveChanges();
		transport.connect();
		transport.sendMessage(message, null);
		transport.close();
	}
	
	Session session(AWSCredentials awsCredentials) {
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "aws");
		props.setProperty("mail.aws.user", awsCredentials.getAWSAccessKeyId());
		props.setProperty("mail.aws.password", awsCredentials.getAWSSecretKey());
		return Session.getInstance(props);		
	}

}
