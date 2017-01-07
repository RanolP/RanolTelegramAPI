package me.ranol.telegramapi.api.telegramobject.message;

import me.ranol.telegramapi.api.telegramobject.interfaces.FileObject;

public class Voice implements FileObject {
	private String file_id;
	private Integer duration;
	private String mime_type;
	private Integer file_size;

	@Override
	public String getId() {
		return file_id;
	}

	public Integer getDuration() {
		return duration;
	}

	public String getMimeType() {
		return mime_type;
	}

	@Override
	public int getSize() {
		return file_size;
	}
}
