package me.ranol.telegramapi.api;

import me.ranol.telegramapi.api.telegramobject.User;

@FunctionalInterface
public interface CommandExecutor {
	public void exec(User user, String commandLine);
}
