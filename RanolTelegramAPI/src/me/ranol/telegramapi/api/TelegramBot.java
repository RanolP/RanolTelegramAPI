package me.ranol.telegramapi.api;

import static me.ranol.telegramapi.api.event.EventType.MESSAGE;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
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
import me.ranol.telegramapi.api.telegramobject.user.User;
import me.ranol.telegramapi.util.Wrap;

public class TelegramBot {
	protected String token;
	private long offset = 0;
	private HashMap<Integer, List<TelegramListener<Event>>> listeners = new HashMap<>();
	private boolean msgLogging = false;
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	private HashMap<String, CommandExecutor> executors = new HashMap<>();
	private User me;

	public final void register() {
		Static.loopTask(new TimerTask() {
			@Override
			public void run() {
				JsonObject o = Requester.getUpdates(offset + 1);
				if (o.get("ok")
					.getAsBoolean()) {
					Wrap<Long> lastMsg = Wrap.of(offset);
					Arrays.stream(GsonManager.parse(o.get("result"), Update[].class))
						.filter(u -> u.getId() > lastMsg.get())
						.forEach(u -> {
							lastMsg.set(Math.max(u.getId(), lastMsg.get()));
							Thread th = new Thread(() -> {
								MessageEvent event = new MessageEvent(u.getMessage(false));
								callEvent(EventType.MESSAGE.id(), event);
							});
							th.start();
						});
					if (offset < lastMsg.get()) offset = lastMsg.get();
				}
			}
		}, 1);
		addMessageListener(e -> {
			String text = e.getMessage()
				.getText();
			if (e.getMessage()
				.getChat() == null) return;
			if (text == null) return;
			if (!text.startsWith("/")) return;
			if (e.getMessage()
				.getEntities() == null) return;
			if (Arrays.stream(e.getMessage()
				.getEntities())
				.filter(en -> !en.getType()
					.equals("bot_command"))
				.count() != 0) return;
			String commandLine = text.split(" ")[0];
			String args = text.substring(commandLine.length())
				.trim();
			if (executors.containsKey(commandLine)) {
				if (msgLogging) {
					Calendar.getInstance()
						.setTimeInMillis(e.getMessage()
							.getDate() * 1000);
					System.out.println("[" + format.format(Calendar.getInstance()
						.getTime()) + "] "
							+ e.getUser()
								.getFullName()
							+ " : " + e.getMessage()
								.getText());
				}
				executors.get(commandLine)
					.exec(e.getMessage()
						.getChat(), args);
				e.setCancelled(true);
			}
		});
		addMessageListener(e -> {
			if (!msgLogging) return;
			Calendar.getInstance()
				.setTimeInMillis(e.getMessage()
					.getDate() * 1000);
			if (e.getUser() != null) {
				System.out.println("[" + format.format(Calendar.getInstance()
					.getTime()) + "] "
						+ e.getUser()
							.getFullName()
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

	public void registerCommand(String label, CommandExecutor command) {
		if (me == null) {
			me = GsonManager.parse(Requester.getMe()
				.get("result"), User.class);
		}
		executors.put("/" + label, command);
		executors.put("/" + label + "@" + me.getUsername(), command);
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
			.filter(l -> l.test(e) && l.valid(e))
			.forEach(l -> {
				if (!e.isCancelled() && l != null) {
					l.recieve(e);
				}
			});
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
