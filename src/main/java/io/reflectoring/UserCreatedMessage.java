package io.reflectoring;

import javax.validation.constraints.NotNull;

public class UserCreatedMessage {

	@NotNull
	private String messageUuid;

	@NotNull
	private User user;

	public UserCreatedMessage() {
	}

	public UserCreatedMessage(@NotNull String messageUuid, @NotNull User user) {
		this.messageUuid = messageUuid;
		this.user = user;
	}

	public String getMessageUuid() {
		return messageUuid;
	}

	public User getUser() {
		return user;
	}
}
