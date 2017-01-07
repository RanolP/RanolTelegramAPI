package me.ranol.telegramapi.api.event;

public abstract class Event {
	boolean cancel;

	public boolean isCancelled() {
		return cancel;
	}

	public void setCancelled(boolean val) {
		cancel = val;
	}
}
