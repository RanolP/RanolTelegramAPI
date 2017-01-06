package me.ranol.telegramapi.api.messaging;

public class FinalTextMessage implements FinalMessage {
	String message;
	boolean notify = true;
	Long replyto;

	public FinalTextMessage(String message) {
		setText(message);
	}

	public String getText() {
		return message;
	}

	public void setText(String message) {
		this.message = message;
	}

	@Override
	public MessageType getType() {
		return MessageType.TEXT;
	}

	public boolean isNotification() {
		return notify;
	}

	public Long getReplyTo() {
		return replyto;
	}

}
