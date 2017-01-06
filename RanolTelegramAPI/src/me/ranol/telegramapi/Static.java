package me.ranol.telegramapi;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class Static {
	private static final HashMap<Integer, TimerTask> tasks = new HashMap<>();
	private static int lastTask = 0;

	public static void loopTask(TimerTask task, int repeat) {
		Timer timer = new Timer();
		timer.schedule(task, 0, repeat);
		tasks.put(lastTask++, task);
	}

	public static void cancelAllTasks() {
		tasks.values()
			.forEach(TimerTask::cancel);
		tasks.clear();
	}
}
