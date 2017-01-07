package me.ranol.telegramapi.api.event;

import me.ranol.telegramapi.api.telegramobject.message.Message;
import me.ranol.telegramapi.api.telegramobject.user.User;

public class MessageEvent extends Event {
	Message message;

	public MessageEvent(Message message) {
		this.message = message;
	}

	public Message getMessage() {
		return message;
	}

	public User getUser() {
		return message.getUser();
	}
}
