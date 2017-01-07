package me.ranol.telegramapi.api.telegramobject.keyboard;

import me.ranol.telegramapi.api.telegramobject.CallbackGame;

public class InlineKeyboardButton {
	private String text;
	private String url;
	private String callback_data;
	private String switch_inline_query;
	private String switch_inline_query_current_chat;
	private CallbackGame callback_game;

	public String getText() {
		return text;
	}

	public String getUrl() {
		return url;
	}

	public String getCallbackData() {
		return callback_data;
	}

	public String getSwitchInlineQuery() {
		return switch_inline_query;
	}

	public String getSwitchInlineQueryCurrentChat() {
		return switch_inline_query_current_chat;
	}

	public CallbackGame getCallbackGame() {
		return callback_game;
	}
}
