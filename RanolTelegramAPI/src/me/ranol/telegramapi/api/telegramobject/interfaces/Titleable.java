package me.ranol.telegramapi.api.telegramobject.interfaces;

public interface Titleable {
	public String getTitle();

	public default boolean hasTitle() {
		return getTitle() != null;
	}
}
