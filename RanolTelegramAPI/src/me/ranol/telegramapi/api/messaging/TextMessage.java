package me.ranol.telegramapi.api.messaging;

import me.ranol.telegramapi.Requester;
import me.ranol.telegramapi.TelegramAPI;

public class TextMessage extends FinalTextMessage implements Message {

	public TextMessage(String message) {
		super(message);
	}

	@Override
	public void send(long to) {
		Requester.requestTextMessage(TelegramAPI.bot(), to, getText(), isNotification(), getReplyTo());
	}

	@Override
	public void send(String to) {
		Requester.requestTextMessage(TelegramAPI.bot(), to, getText(), isNotification(), getReplyTo());
	}

	public void setReplyTo(long reply) {
		this.replyto = reply;
	}

}
