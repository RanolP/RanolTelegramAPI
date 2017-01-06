package me.ranol.telegramapi.api.telegramobject.message;

import me.ranol.telegramapi.api.telegramobject.Contact;
import me.ranol.telegramapi.api.telegramobject.Game;
import me.ranol.telegramapi.api.telegramobject.Location;
import me.ranol.telegramapi.api.telegramobject.Optional;
import me.ranol.telegramapi.api.telegramobject.PhotoSize;
import me.ranol.telegramapi.api.telegramobject.User;
import me.ranol.telegramapi.api.telegramobject.Venue;
import me.ranol.telegramapi.api.telegramobject.chat.Chat;
import me.ranol.telegramapi.api.telegramobject.interfaces.IntIdObject;
import me.ranol.telegramapi.api.telegramobject.interfaces.SendableObject;

public class Message implements IntIdObject, SendableObject {
	private Long message_id;
	@Optional
	private User from;
	private Integer date;
	private Chat chat;
	@Optional
	private User forward_from;
	@Optional
	private Chat forward_from_chat;
	@Optional
	private Integer forward_from_message_id;
	@Optional
	private Integer forward_date;
	@Optional
	private Integer reply_to_message;
	@Optional
	private Integer edit_date;
	@Optional
	private String text;
	@Optional
	private MessageEntity[] entities;
	@Optional
	private Audio audio;
	@Optional
	private Document document;
	@Optional
	private Game game;
	@Optional
	private PhotoSize[] photo;
	@Optional
	private Sticker sticker;
	@Optional
	private Video video;
	@Optional
	private Voice voice;
	@Optional
	private String caption;
	@Optional
	private Contact contact;
	@Optional
	private Location location;
	@Optional
	private Venue venue;
	@Optional
	private User new_chat_member;
	@Optional
	private User left_chat_member;
	@Optional
	private String new_chat_title;
	@Optional
	private PhotoSize[] new_chat_photo;
	@Optional
	private Boolean delete_chat_photo;
	@Optional
	private Boolean group_chat_created;
	@Optional
	private Boolean supergroup_chat_created;
	@Optional
	private Boolean channel_chat_created;
	@Optional
	private Integer migrate_to_chat_id;
	@Optional
	private Integer migrate_from_chat_id;
	@Optional
	private Message pinned_message;

	@Override
	public Long getId() {
		return message_id;
	}

	@Override
	public User getSender() {
		return from;
	}

	public Integer getDate() {
		return date;
	}

	public Chat getChat() {
		return chat;
	}

	public User getForwardFrom() {
		return forward_from;
	}

	public Chat getForwardFromChat() {
		return forward_from_chat;
	}

	public Integer getForwardFromMessageId() {
		return forward_from_message_id;
	}

	public Integer getForwardDate() {
		return forward_date;
	}

	public Integer getReplyToMessage() {
		return reply_to_message;
	}

	public Integer getEditDate() {
		return edit_date;
	}

	public String getText() {
		return text;
	}

	public MessageEntity[] getEntities() {
		return entities;
	}
}
