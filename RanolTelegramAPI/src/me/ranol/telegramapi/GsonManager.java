package me.ranol.telegramapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

public class GsonManager {
	private static Gson gson = new GsonBuilder().setPrettyPrinting()
		.create();

	public static <T> T parse(JsonElement json, Class<T> clazz) {
		return gson.fromJson(json, clazz);
	}
}
