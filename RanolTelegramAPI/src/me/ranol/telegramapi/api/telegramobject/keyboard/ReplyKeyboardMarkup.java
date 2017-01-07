package me.ranol.telegramapi.api.telegramobject.keyboard;

public class ReplyKeyboardMarkup {
	private KeyboardButton[][] keyboard;
	private Boolean resize_keyboard;
	private Boolean one_time_keyboard;
	private Boolean selective;

	public KeyboardButton[][] getKeyboard() {
		return keyboard;
	}

	public Boolean isResizeKeyboard() {
		return resize_keyboard;
	}

	public Boolean isOneTimeKeyboard() {
		return one_time_keyboard;
	}

	public Boolean isSelective() {
		return selective;
	}
}
