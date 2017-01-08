package me.ranol.telegramapi;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class GsonManager {
	private static Gson gson = new GsonBuilder().setPrettyPrinting()
		.create();
	private static JsonParser parser = new JsonParser();

	public static <T> T parse(JsonElement json, Class<T> clazz) {
		return gson.fromJson(json, clazz);
	}

	public static JsonElement parse(Object o) {
		return parser.parse(gson.toJson(o));
	}

	public static void print(JsonElement e) {
		System.out.println(gson.toJson(e));
	}

	public static JsonObject load(File target) {
		try (FileReader reader = new FileReader(target)) {
			JsonElement e = parser.parse(reader);
			return e instanceof JsonObject ? (JsonObject) e : new JsonObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new JsonObject();
	}

	public static void save(JsonObject prop, File target) {
		try (FileWriter writer = new FileWriter(target)) {
			writer.write(gson.toJson(prop));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
