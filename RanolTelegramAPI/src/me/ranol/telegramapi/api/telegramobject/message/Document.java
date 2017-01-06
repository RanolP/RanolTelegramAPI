package me.ranol.telegramapi.api.telegramobject.message;

import me.ranol.telegramapi.api.telegramobject.Optional;
import me.ranol.telegramapi.api.telegramobject.PhotoSize;
import me.ranol.telegramapi.api.telegramobject.interfaces.FileObject;

public class Document implements FileObject {
	private String file_id;
	@Optional
	private PhotoSize thumb;
	@Optional
	private String file_name;
	@Optional
	private String mime_type;
	@Optional
	private int file_size;

	@Override
	public String getId() {
		return file_id;
	}

	public PhotoSize getThumb() {
		return thumb;
	}

	public String getFileName() {
		return file_name;
	}

	public String getMimeType() {
		return mime_type;
	}

	@Override
	public int getSize() {
		return file_size;
	}

}
