package me.ranol.telegramapi.api.event;

public enum EventType {
	MESSAGE(0);
	private int id;

	private EventType(int id) {
		this.id = id;
	}

	public int id() {
		return id;
	}
}
