package me.ranol.telegramapi;

import me.ranol.telegramapi.api.TelegramBot;

public class TelegramAPI {
	private static TelegramBot bot;

	public static <T extends TelegramBot> T startBot(Class<T> clazz, String token) {
		if (bot != null) {
			throw new UnsupportedOperationException("Cannot start new bot, already started!");
		}
		try {
			T bot = clazz.newInstance();
			bot.setToken(token);
			TelegramAPI.bot = bot;
			bot.register();
			bot.onStart();
			return bot;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static TelegramBot bot() {
		return bot;
	}
}
