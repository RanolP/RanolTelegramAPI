package me.ranol.telegramapi.api.event;

@FunctionalInterface
public interface TelegramListener<T extends Event> {
	public void recieve(T obj);

	default void test0(T e) {
	}

	public default boolean test(Event e) {
		try {
			test0((T) e);
			return true;
		} catch (ClassCastException ex) {
		}
		return false;
	}

	public default boolean valid(T e) {
		return true;
	}
}
