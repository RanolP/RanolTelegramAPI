package me.ranol.telegramapi.api.telegramobject.message;

import me.ranol.telegramapi.api.telegramobject.Optional;
import me.ranol.telegramapi.api.telegramobject.interfaces.FileObject;
import me.ranol.telegramapi.api.telegramobject.interfaces.Titleable;

public class Audio implements FileObject, Titleable {
	private String file_id;
	private int duration;
	@Optional
	private String performer;
	@Optional
	private String title;
	@Optional
	private String mime_type;
	@Optional
	private int file_size;

	public String getId() {
		return file_id;
	}

	public int getDuration() {
		return duration;
	}

	public String getPerformer() {
		return performer;
	}

	@Override
	public String getTitle() {
		return title;
	}

	public String getMimeType() {
		return mime_type;
	}

	@Override
	public int getSize() {
		return file_size;
	}
}
