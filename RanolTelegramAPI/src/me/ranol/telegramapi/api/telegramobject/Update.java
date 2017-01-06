package me.ranol.telegramapi.api.telegramobject;

import me.ranol.telegramapi.api.telegramobject.interfaces.IntIdObject;
import me.ranol.telegramapi.api.telegramobject.message.Message;

public class Update implements IntIdObject {
	private Long update_id;
	private Message message;
	private Message edited_message;
	private Message channel_post;
	private Message edited_channel_post;
	private InlineQuery inline_query;
	private ChosenInlineResult chosen_inline_result;
	private CallbackQuery callback_query;

	@Override
	public Long getId() {
		return update_id;
	}

	public Message getMessage(boolean edited) {
		return edited ? edited_message : message;
	}

	public Message getChannelPost(boolean edited) {
		return edited ? edited_channel_post : channel_post;
	}

	public InlineQuery getInlineQuery() {
		return inline_query;
	}

	public ChosenInlineResult getInlineResult() {
		return chosen_inline_result;
	}

	public CallbackQuery getCallbackQuery() {
		return callback_query;
	}
}
