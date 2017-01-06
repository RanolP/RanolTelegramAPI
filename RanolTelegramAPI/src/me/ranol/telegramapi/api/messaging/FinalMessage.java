package me.ranol.telegramapi.api.messaging;

import static me.ranol.telegramapi.api.messaging.MessageType.*;

public interface FinalMessage {
	public MessageType getType();

	public default boolean isText() {
		return getType() == TEXT;
	}

	public default boolean isPhoto() {
		return getType() == PHOTO;
	}

	public default boolean isSticker() {
		return getType() == STICKER;
	}

	public default boolean isFile() {
		return getType() == FILE;
	}

	public default boolean isVideo() {
		return getType() == VIDEO;
	}

	public default boolean isExtra() {
		return getType() == ETC;
	}
}
