package me.ranol.telegramapi.api.telegramobject;

import me.ranol.telegramapi.api.telegramobject.interfaces.StringIdObject;
import me.ranol.telegramapi.api.telegramobject.user.User;

public class ChosenInlineResult implements StringIdObject{
	private String result_id;
	private User from;
	private Location location;
	private String inline_message_id;
	private String query;

	public String getId() {
		return result_id;
	}

	public User getSender() {
		return from;
	}

	public Location getLocation() {
		return location;
	}

	public String getInlineMessageId() {
		return inline_message_id;
	}

	public String getQuery() {
		return query;
	}
}
