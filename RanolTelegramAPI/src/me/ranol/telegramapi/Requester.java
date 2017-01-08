package me.ranol.telegramapi;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClientBuilder;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import me.ranol.telegramapi.api.TelegramBot;

public class Requester {

	public static class StringEntryBuilder {
		Map<String, String> entries = new HashMap<>();

		private StringEntryBuilder() {
		}

		public static StringEntryBuilder create() {
			return new StringEntryBuilder();
		}

		public StringEntryBuilder add(String key, String value) {
			entries.put(key, value);
			return this;
		}

		public StringEntryBuilder addIfNonNullNot(String key, Boolean obj) {
			if (obj != null) add(key, Boolean.toString(!obj));
			return this;
		}

		public StringEntryBuilder addIfNonNull(String key, Object obj) {
			if (obj != null) add(key, obj.toString());
			return this;
		}

		public Map<String, String> build() {
			return entries;
		}
	}

	private static JsonObject request0(String url, Map<String, String> entries) {
		try {
			HttpPost post = new HttpPost(url);
			if (entries != null && !entries.isEmpty()) {
				MultipartEntityBuilder builder = MultipartEntityBuilder.create();
				for (Entry<String, String> entry : entries.entrySet())
					builder
						.addTextBody(entry.getKey(), entry.getValue(), ContentType.create("text/plain", Consts.UTF_8));
				post.setEntity(builder.build());
			}
			HttpClient client = HttpClientBuilder.create()
				.build();
			HttpResponse res = client.execute(post);
			InputStreamReader reader = new InputStreamReader(res.getEntity()
				.getContent());
			return new JsonParser().parse(reader)
				.getAsJsonObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static JsonObject request(String extra, Map<String, String> entries) {
		return request0("https://api.telegram.org/bot" + TelegramAPI.bot()
			.getToken() + "/" + extra, entries);
	}

	public static JsonObject getMe() {
		return request("getMe", null);
	}

	public static JsonObject sendMessage(long id, String text, Boolean notify, Long replyTo) {
		return request("sendMessage", StringEntryBuilder.create()
			.add("chat_id", Long.toString(id))
			.add("text", text)
			.addIfNonNullNot("disable_notification", notify)
			.addIfNonNull("reply_to_text_id", replyTo)
			.build());
	}

	public static JsonObject sendMessage(String id, String text, Boolean notify, Long replyTo) {
		return request("sendMessage", StringEntryBuilder.create()
			.add("chat_id", id)
			.add("text", text)
			.addIfNonNullNot("disable_notification", notify)
			.addIfNonNull("reply_to_text_id", replyTo)
			.build());
	}

	public static JsonObject getUpdates(Long offset) {
		return request("getUpdates", StringEntryBuilder.create()
			.addIfNonNull("offset", offset)
			.add("timeout", "100")
			.build());
	}
}
