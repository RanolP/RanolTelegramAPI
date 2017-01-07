package me.ranol.telegramapi.api.telegramobject.message;

import me.ranol.telegramapi.api.telegramobject.Optional;
import me.ranol.telegramapi.api.telegramobject.PhotoSize;

public class Sticker extends PhotoSize {
	@Optional
	private PhotoSize thumb;
	@Optional
	private String emoji;

	public PhotoSize getThumb() {
		return thumb;
	}

	public String getEmoji() {
		return emoji;
	}
}
