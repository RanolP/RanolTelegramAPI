package me.ranol.telegramapi.api.telegramobject;

import me.ranol.telegramapi.api.telegramobject.interfaces.FileObject;

public class PhotoSize implements FileObject {
	private String file_id;
	private int width;
	private int height;
	@Optional
	private int file_size;

	@Override
	public String getId() {
		return file_id;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	@Override
	public int getSize() {
		return file_size;
	}
}
