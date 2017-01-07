package me.ranol.telegramapi.api.telegramobject.interfaces;

import me.ranol.telegramapi.api.telegramobject.user.User;

public interface UserObject {
	public User getUser();

	public default boolean hasUser() {
		return getUser() != null;
	}

	public default String getSenderFirstName() {
		return hasUser() ? getUser().getFirstName() : null;
	}

	public default String getSenderLastName() {
		return hasUser() ? getUser().getLastName() : null;
	}

	public default String getSenderFullName() {
		return hasUser() ? getUser().getFullName() : null;
	}

	public default Long getSenderId() {
		return hasUser() ? getUser().getId() : null;
	}

	public default String getSenderUsername() {
		return hasUser() ? getUser().getUsername() : null;
	}

	public default boolean hasSenderUsername() {
		return hasUser() && getUser().hasUsername();
	}

	public default boolean hasSenderLastName() {
		return hasUser() && getUser().hasLastName();
	}
}
