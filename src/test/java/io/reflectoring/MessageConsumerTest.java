package io.reflectoring;

import java.io.IOException;

import au.com.dius.pact.consumer.MessagePactBuilder;
import au.com.dius.pact.consumer.MessagePactProviderRule;
import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.model.v3.messaging.MessagePact;
import org.apache.commons.lang3.NotImplementedException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageConsumerTest {

	@Rule
	public MessagePactProviderRule mockProvider = new MessagePactProviderRule(this);
	private byte[] currentMessage;

	@Autowired
	private MessageConsumer messageConsumer;

	@Pact(provider = "userservice", consumer = "userclient")
	public MessagePact userCreatedMessagePact(MessagePactBuilder builder) {
		throw new NotImplementedException("not implemented yet");
	}

	@Test
	@PactVerification("userCreatedMessagePact")
	public void verifyCreatePersonPact() throws IOException {
		messageConsumer.consumeStringMessage(new String(this.currentMessage));
	}

	/**
	 * This method is called by the Pact framework.
	 */
	public void setMessage(byte[] message) {
		this.currentMessage = message;
	}

}
