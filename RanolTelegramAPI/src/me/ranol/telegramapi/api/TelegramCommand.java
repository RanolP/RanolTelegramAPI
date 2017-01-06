package me.ranol.telegramapi.api;

import me.ranol.telegramapi.api.telegramobject.User;

public class TelegramCommand {
	CommandExecutor executor = (invoker, line) -> {
	};

	// TODO make class entry
	public void invoke(User invoker, String commandLine) {
		executor.exec(invoker, commandLine);
	}
}
