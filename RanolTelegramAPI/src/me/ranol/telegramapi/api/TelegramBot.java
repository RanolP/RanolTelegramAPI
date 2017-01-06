package me.ranol.telegramapi.api;

import static me.ranol.telegramapi.api.event.EventType.MESSAGE;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.TimerTask;

import com.google.gson.JsonObject;

import me.ranol.telegramapi.GsonManager;
import me.ranol.telegramapi.Requester;
import me.ranol.telegramapi.Static;
import me.ranol.telegramapi.api.event.Event;
import me.ranol.telegramapi.api.event.EventType;
import me.ranol.telegramapi.api.event.MessageEvent;
import me.ranol.telegramapi.api.event.MessageListener;
import me.ranol.telegramapi.api.event.TelegramListener;
import me.ranol.telegramapi.api.telegramobject.Update;
import me.ranol.telegramapi.util.Wrap;

public class TelegramBot {
	protected String token;
	private long offset = 0;
	private HashMap<Integer, List<TelegramListener<Event>>> listeners = new HashMap<>();
	private boolean msgLogging = false;
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	public final void registerThings() {
		Static.loopTask(new TimerTask() {
			@Override
			public void run() {
				JsonObject o = Requester.getUpdates(TelegramBot.this, offset + 1);
				if (o.get("ok")
					.getAsBoolean()) {
					Wrap<Long> lastMsg = Wrap.of(offset);
					o.get("result")
						.getAsJsonArray()
						.forEach(e -> {
							Update update = GsonManager.parse(e, Update.class);
							MessageEvent event = new MessageEvent(update.getMessage(false));
							if (update.getId() <= lastMsg.get()) return;
							lastMsg.set(Math.max(update.getId(), lastMsg.get()));
							callEvent(EventType.MESSAGE.id(), event);
						});
					if (offset < lastMsg.get()) offset = lastMsg.get();
				}
			}
		}, 1);
		addMessageListener(e -> {
			if (!msgLogging) return;
			Calendar.getInstance()
				.setTimeInMillis(e.getMessage()
					.getDate() * 1000);
			if (e.getSender() != null) {
				System.out.println("[" + format.format(Calendar.getInstance()
					.getTime()) + "] "
						+ e.getSender()
							.getUsername()
						+ " : " + e.getMessage()
							.getText());
			} else {
				System.out.println("[" + format.format(Calendar.getInstance()
					.getTime()) + "] 'Unknown User' : "
						+ e.getMessage()
							.getText());
			}
		});
	}

	public void onStart() {
	}

	public void setLogging(boolean logging) {
		msgLogging = logging;
	}

	public boolean registerCommand(TelegramCommand command) {
		// TODO make method body
		return false;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public <T extends Event> void callEvent(int id, T e) {
		if (e == null) return;
		listeners.get(id)
			.stream()
			.filter(l -> l.test(e))
			.forEach(l -> l.recieve(e));
	}

	public <T extends TelegramListener> void addListener(EventType type, T listener) {
		if (!listeners.containsKey(type.id())) listeners.put(type.id(), new ArrayList<>());
		listeners.get(type.id())
			.add(listener);
	}

	public void addMessageListener(MessageListener listener) {
		addListener(MESSAGE, listener);
	}
}
