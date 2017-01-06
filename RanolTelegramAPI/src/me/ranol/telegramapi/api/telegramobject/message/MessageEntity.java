package me.ranol.telegramapi.api.telegramobject.message;

import me.ranol.telegramapi.api.telegramobject.Optional;
import me.ranol.telegramapi.api.telegramobject.User;

public class MessageEntity {
	private String type;
	private int offset;
	private int length;
	@Optional
	private String url;
	@Optional
	private User user;

	public String getType() {
		return type;
	}

	public int getOffset() {
		return offset;
	}

	public int getLength() {
		return length;
	}

	public String getUrl() {
		return url;
	}

	public User getMentionUser() {
		return user;
	}
}
