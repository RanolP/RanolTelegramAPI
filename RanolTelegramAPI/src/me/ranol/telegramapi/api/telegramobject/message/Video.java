package me.ranol.telegramapi.api.telegramobject.message;

import me.ranol.telegramapi.api.telegramobject.Optional;
import me.ranol.telegramapi.api.telegramobject.PhotoSize;

public class Video extends PhotoSize {
	private Integer duration;
	@Optional
	private PhotoSize thumb;
	@Optional
	private String mime_type;

	public Integer getDuration() {
		return duration;
	}

	public PhotoSize getThumb() {
		return thumb;
	}

	public String getMimeType() {
		return mime_type;
	}
}
