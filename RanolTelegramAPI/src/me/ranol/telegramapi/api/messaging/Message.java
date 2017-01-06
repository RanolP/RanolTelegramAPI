package me.ranol.telegramapi.api.messaging;

public interface Message extends FinalMessage {
	public void send(long to);

	public void send(String to);
}
