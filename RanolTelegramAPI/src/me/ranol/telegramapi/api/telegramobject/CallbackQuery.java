package me.ranol.telegramapi.api.telegramobject;

import me.ranol.telegramapi.api.telegramobject.interfaces.UserObject;
import me.ranol.telegramapi.api.telegramobject.interfaces.StringIdObject;
import me.ranol.telegramapi.api.telegramobject.message.Message;
import me.ranol.telegramapi.api.telegramobject.user.User;

public class CallbackQuery implements StringIdObject, UserObject {
	private String id;
	private User from;
	private Message message;
	private String inline_message_id;
	private String chat_instance;
	private String data;
	private String game_short_name;

	@Override
	public String getId() {
		return id;
	}

	@Override
	public User getUser() {
		return from;
	}

	public Message getMessage() {
		return message;
	}

	public String getInlineMessageId() {
		return inline_message_id;
	}

	public String getChatInstance() {
		return chat_instance;
	}

	public String getData() {
		return data;
	}

	public String getGameShortName() {
		return game_short_name;
	}
}
