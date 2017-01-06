package me.ranol.telegramapi.api.event;

import me.ranol.telegramapi.api.telegramobject.User;
import me.ranol.telegramapi.api.telegramobject.message.Message;

public class MessageEvent implements Event {
	Message message;

	public MessageEvent(Message message) {
		this.message = message;
	}

	public Message getMessage() {
		return message;
	}

	public User getSender() {
		return message.getSender();
	}
}
