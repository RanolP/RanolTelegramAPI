package me.ranol.telegramapi.api.telegramobject.user;

import me.ranol.telegramapi.api.telegramobject.PhotoSize;

public class UserProfilePhotos {
	private Integer total_count;
	private PhotoSize[][] photos;

	public Integer getTotalCount() {
		return total_count;
	}

	public PhotoSize[][] getPhotos() {
		return photos;
	}
}
