package me.ranol.telegramapi.api.telegramobject.message;

import me.ranol.telegramapi.api.telegramobject.Game;
import me.ranol.telegramapi.api.telegramobject.Location;
import me.ranol.telegramapi.api.telegramobject.Optional;
import me.ranol.telegramapi.api.telegramobject.PhotoSize;
import me.ranol.telegramapi.api.telegramobject.Venue;
import me.ranol.telegramapi.api.telegramobject.chat.Chat;
import me.ranol.telegramapi.api.telegramobject.chat.ChatType;
import me.ranol.telegramapi.api.telegramobject.interfaces.IntIdObject;
import me.ranol.telegramapi.api.telegramobject.interfaces.UserObject;
import me.ranol.telegramapi.api.telegramobject.user.User;

public class Message implements IntIdObject, UserObject {
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
	private Message reply_to_message;
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
	public User getUser() {
		return from;
	}

	public Integer getDate() {
		return date;
	}

	public Chat getChat() {
		return chat;
	}

	public Long getChatId() {
		return chat != null ? chat.getId() : null;
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

	public Message getReplyToMessage() {
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

	public boolean hasEntities() {
		return entities != null && entities.length > 0;
	}

	public Audio getAudio() {
		return audio;
	}

	public boolean hasAudio() {
		return audio != null;
	}

	public Document getDocument() {
		return document;
	}

	public boolean hasDocument() {
		return document != null;
	}

	public Game getGame() {
		return game;
	}

	public boolean hasGame() {
		return document != null;
	}

	public PhotoSize[] getPhoto() {
		return photo;
	}

	public boolean hasPhoto() {
		return photo != null && photo.length > 0;
	}

	public Sticker getSticker() {
		return sticker;
	}

	public boolean hasSticker() {
		return sticker != null;
	}

	public Video getVideo() {
		return video;
	}

	public boolean hasVideo() {
		return video != null;
	}

	public Voice getVoice() {
		return voice;
	}

	public boolean hasVoice() {
		return voice != null;
	}

	public String getCaption() {
		return caption;
	}

	public Location getLocation() {
		return location;
	}

	public boolean hasLocation() {
		return location != null;
	}

	public Venue getVenue() {
		return venue;
	}

	public boolean hasVenue() {
		return venue != null;
	}

	public User getNewChatMember() {
		return new_chat_member;
	}

	public User getLeftChatMember() {
		return left_chat_member;
	}

	public String getNewChatTitle() {
		return new_chat_title;
	}

	public PhotoSize[] getNewChatPhoto() {
		return new_chat_photo;
	}

	public Boolean isDeleteChatPhoto() {
		return delete_chat_photo;
	}

	public Boolean isCreated(ChatType type) {
		switch (type) {
		case CHANNEL:
			return channel_chat_created == true;
		case GROUP:
			return group_chat_created == true;
		case SUPERGROUP:
			return supergroup_chat_created == true;
		case PRIVATE:
			return chat != null && chat.getType() == ChatType.PRIVATE;
		case UNKNOWN:
		default:
			return null;
		}
	}

	public Integer getMigrateToChatId() {
		return migrate_to_chat_id;
	}

	public Integer getMigrateFromChatId() {
		return migrate_from_chat_id;
	}

	public Message getPinnedMessage() {
		return pinned_message;
	}
}
