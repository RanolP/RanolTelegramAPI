package me.ranol.telegramapi.api;

import me.ranol.telegramapi.api.telegramobject.chat.Chat;

@FunctionalInterface
public interface CommandExecutor {
	public void exec(Chat chat, String args);
}
