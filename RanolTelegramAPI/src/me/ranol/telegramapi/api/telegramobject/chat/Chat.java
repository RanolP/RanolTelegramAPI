package me.ranol.telegramapi.api.telegramobject.chat;

import me.ranol.telegramapi.api.telegramobject.Optional;
import me.ranol.telegramapi.api.telegramobject.user.User;

public class Chat extends User {
	private String type;
	@Optional
	private String title;
	private boolean all_members_are_administrators;

	public ChatType getType() {
		return ChatType.byName(type);
	}

	public String getTitle() {
		return title;
	}

	public boolean isAllMembersAdmin() {
		return all_members_are_administrators;
	}
}
