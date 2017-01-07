package me.ranol.telegramapi.api.event;

public interface MessageListener extends TelegramListener<MessageEvent> {
	@Override
	default boolean valid(MessageEvent e) {
		return e.getMessage() != null;
	}
}
