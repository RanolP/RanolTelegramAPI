package me.ranol.telegramapi;

import me.ranol.telegramapi.api.TelegramBot;
import me.ranol.telegramapi.api.messaging.TextMessage;

public class HowToMakeBot extends TelegramBot {
	public static void main(String[] args) {
		// Make your own main method.
		// And bot class must extends a TelegramBot class.
		TelegramAPI.startBot(HowToMakeBot.class);
		// now call the 'startBot' method with argument.
		// it will start your bot!
		// onStart method calling on starting
	}

	@Override
	public void onStart() {
		// set your bot token,
		setToken("HERE INSERT YOUR BOT TOKEN");
		// you can logging chats
		setLogging(true);
		// you can add listener, and can use lambda!
		addMessageListener(e -> {
			if (e.getSender() != null) {
				// TextMessage can send message!
				TextMessage msg = new TextMessage("Simply Response bot.");
				// give String or Integer id
				msg.send(e.getSender()
					.getId());
			}
		});
	}
}
