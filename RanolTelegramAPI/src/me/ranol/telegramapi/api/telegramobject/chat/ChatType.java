package me.ranol.telegramapi.api.telegramobject.chat;

public enum ChatType {
	PRIVATE("private"),
	GROUP("group"),
	SUPERGROUP("supergroup"),
	CHANNEL("channel"),
	UNKNOWN("ERROR: Unknown chat type found");
	String name;

	ChatType(String name) {
	}

	public String getName() {
		return name;
	}

	public boolean isUser() {
		return this == ChatType.PRIVATE;
	}

	public static ChatType byName(String name) {
		for (ChatType type : values()) {
			if (type.getName()
				.equals(name)) return type;
		}
		return ChatType.UNKNOWN;
	}
}
