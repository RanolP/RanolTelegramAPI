package test.telegramapi;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import me.ranol.telegramapi.api.TelegramBot;
import me.ranol.telegramapi.api.messaging.TextMessage;
import me.ranol.telegramapi.api.telegramobject.message.Message;

public class TestBot extends TelegramBot {
	List<String> texts = new ArrayList<>();
	Random r = new Random();
	HashMap<Long, String> joinMsg = new HashMap<>();
	HashMap<Long, String> quitMsg = new HashMap<>();
	String defaultJoin = "어서와, {full}!";
	String defaultExit = "잘가, {full}!";

	@Override
	public void onStart() {
		setLogging(true);
		addMessageListener(e -> {
			Message m = e.getMessage();
			if (m.getNewChatMember() != null) {
				new TextMessage(joinMsg.getOrDefault(m.getChatId(), defaultJoin)
					.replace("{full}", m.getNewChatMember()
						.getFullName())
					.replace("{first}", m.getNewChatMember()
						.getFirstName())
					.replace("{last}", m.getNewChatMember()
						.getFullName())
					.replace("{id}", m.getNewChatMember()
						.getUsername())).send(m.getChatId());
			}
			if (e.getMessage()
				.getLeftChatMember() != null) {
				new TextMessage(quitMsg.getOrDefault(e.getMessage()
					.getChatId(), defaultExit)
					.replace("{full}", m.getLeftChatMember()
						.getFullName())
					.replace("{first}", m.getLeftChatMember()
						.getFirstName())
					.replace("{last}", m.getLeftChatMember()
						.getFullName())
					.replace("{id}", m.getLeftChatMember()
						.getUsername())).send(m.getChatId());
			}
		});

		registerCommand("help", (c, a) -> {
			TextMessage help = new TextMessage(new StringBuilder().append("\n")
				.append("/help - 도움말을 띄웁니다.")
				.append("\n")
				.append("/ws - 랜덤한 명언을 하나 띄웁니다.")
				.append("\n")
				.append("/join [메시지] - 입장 메시지를 변경합니다.")
				.append("\n")
				.append("/quit [메시지] - 퇴장 메시지를 변경합니다.")
				.append("\n")
				.append("사용 가능 변수 : {full}, {first}, {last}, {id}")
				.append("\n")
				.append("/msg - 등록된 메시지를 봅니다.")
				.toString());
			help.send(c.getId());
		});
		registerCommand("ws", (c, a) -> {
			String word = texts.get(r.nextInt(texts.size()));
			TextMessage msg = new TextMessage("선택된 명언 : \n" + word);
			msg.send(c.getId());
		});
		registerCommand("join", (c, a) -> {
			TextMessage result = new TextMessage("아무 작업도 수행하지 않았습니다.");
			if (a.isEmpty()) {
				result.setText("입장 메시지를 초기화하였습니다.\n현재 메시지:\n" + defaultJoin);
				joinMsg.put(c.getId(), defaultJoin);
			} else {
				result.setText("입장 메시지를 설정하였습니다.\n현재 메시지:\n" + a);
				joinMsg.put(c.getId(), a);
			}
			result.send(c.getId());
		});
		registerCommand("quit", (c, a) -> {
			TextMessage result = new TextMessage("아무 작업도 수행하지 않았습니다.");
			if (a.isEmpty()) {
				result.setText("퇴장 메시지를 초기화하였습니다.\n현재 메시지:\n잘가, {full}!");
				quitMsg.put(c.getId(), defaultExit);
			} else {
				result.setText("퇴장 메시지를 설정하였습니다.\n현재 메시지:\n" + a);
				quitMsg.put(c.getId(), a);
			}
			result.send(c.getId());
		});
		registerCommand("msg", (c, a) -> {
			TextMessage result = new TextMessage(new StringBuilder().append("")
				.append("--메시지--")
				.append("\n")
				.append("입장 : " + joinMsg.getOrDefault(c.getId(), defaultJoin))
				.append("\n")
				.append("퇴장 : " + quitMsg.getOrDefault(c.getId(), defaultExit))
				.toString());
			result.send(c.getId());
		});
		load();
		System.out.println("Bot Initialize Complete.");
	}

	@Override
	public void onEnd() {
		getProperty().set("words", texts);
		getProperty().set("joinMessages", joinMsg);
		getProperty().set("quitMessages", quitMsg);
	}

	public void load() {
		texts.addAll(getProperty().get("words", List.class, Collections.emptyList()));
		Map<String, String> map = getProperty().get("joinMessages", Map.class, Collections.emptyMap());
		map.entrySet()
			.stream()
			.map(e -> new AbstractMap.SimpleEntry<>(Long.parseLong(e.getKey()
				.replaceAll("[^0-9\\-]", "")), e.getValue()))
			.forEach(e -> joinMsg.put(e.getKey(), e.getValue()));
		Map<String, String> map2 = getProperty().get("quitMessages", Map.class, Collections.emptyMap());
		map2.entrySet()
			.stream()
			.map(e -> new AbstractMap.SimpleEntry<>(Long.parseLong(e.getKey()
				.replaceAll("[^0-9\\-]", "")), e.getValue()))
			.forEach(e -> quitMsg.put(e.getKey(), e.getValue()));
	}
}
