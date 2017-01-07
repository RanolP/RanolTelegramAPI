package me.ranol.telegramapi.api.telegramobject.chat;

import me.ranol.telegramapi.api.telegramobject.user.User;

public class ChatMember {
	public static enum MemberStatus {
		CREATOR("creator"),
		ADMIN("administrator"),
		MEMBER("member"),
		LEFT("left"),
		KICKED("kicked"),
		UNKNOWN("Unknown status found");
		String name;

		MemberStatus(String name) {
			this.name = name;
		}

		public static MemberStatus byName(String name) {
			for (MemberStatus status : values()) {
				if (status.name.equals(name)) return status;
			}
			return UNKNOWN;
		}
	}

	private User user;
	private String status;

	public User getUser() {
		return user;
	}

	public MemberStatus getStatus() {
		return MemberStatus.byName(status);
	}
}
