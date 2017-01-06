package me.ranol.telegramapi.api.telegramobject;

import me.ranol.telegramapi.api.telegramobject.interfaces.IntIdObject;

public class User implements IntIdObject {
	private Long id;
	private String first_name;
	@Optional
	private String last_name;
	@Optional
	private String username;

	@Override
	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return first_name;
	}

	public boolean hasLastName() {
		return last_name != null && !last_name.isEmpty();
	}

	public String getLastName() {
		return last_name;
	}

	public boolean hasUsername() {
		return username != null && !username.isEmpty();
	}

	public String getUsername() {
		return username;
	}
}
