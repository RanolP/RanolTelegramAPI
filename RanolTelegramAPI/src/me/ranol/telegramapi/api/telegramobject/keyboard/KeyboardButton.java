package me.ranol.telegramapi.api.telegramobject.keyboard;

public class KeyboardButton {
	private String text;
	private Boolean request_contact;
	private Boolean request_location;

	public String getText() {
		return text;
	}

	public Boolean isRequestContact() {
		return request_contact;
	}

	public Boolean isRequestLocation() {
		return request_location;
	}
}
