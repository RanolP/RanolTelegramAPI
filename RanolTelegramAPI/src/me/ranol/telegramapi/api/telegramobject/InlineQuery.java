package me.ranol.telegramapi.api.telegramobject;

import me.ranol.telegramapi.api.telegramobject.interfaces.StringIdObject;
import me.ranol.telegramapi.api.telegramobject.user.User;

public class InlineQuery implements StringIdObject {
	private String id;
	private User from;
	private Location location;
	private String query;
	private String offset;

	@Override
	public String getId() {
		return id;
	}

	public User getSender() {
		return from;
	}

	public Location getLocation() {
		return location;
	}

	public String getQuery() {
		return query;
	}

	public String getOffset() {
		return offset;
	}
}
