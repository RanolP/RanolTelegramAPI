package me.ranol.telegramapi.api.telegramobject.message;

import me.ranol.telegramapi.api.telegramobject.Optional;

public class Contact {
	private String phone_number;
	private String first_name;
	@Optional
	private String last_name;
	@Optional
	private Integer user_id;

	public String getPhoneNumber() {
		return phone_number;
	}

	public String getFirstName() {
		return first_name;
	}

	public String getLastName() {
		return last_name;
	}

	public Integer getUserId() {
		return user_id;
	}
}
