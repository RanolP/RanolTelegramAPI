package me.ranol.telegramapi.api.telegramobject;

public class ResponseParameters {
	private Integer migrate_to_chat_id;
	private Integer retry_after;

	public Integer getMigrateToChatId() {
		return migrate_to_chat_id;
	}

	public Integer getRetryAfter() {
		return retry_after;
	}
}
