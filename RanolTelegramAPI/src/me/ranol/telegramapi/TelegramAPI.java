package me.ranol.telegramapi;

import me.ranol.telegramapi.api.TelegramBot;

public class TelegramAPI {
	private static TelegramBot bot;

	public static <T extends TelegramBot> T startBot(Class<T> clazz) {
		if (bot != null) {
			throw new UnsupportedOperationException("Cannot start new bot, already started!");
		}
		try {
			T bot = clazz.newInstance();
			bot.registerThings();
			bot.onStart();
			TelegramAPI.bot = bot;
			return bot;
		} catch (Exception e) {

		}
		return null;
	}

	public static TelegramBot bot() {
		return bot;
	}
}
