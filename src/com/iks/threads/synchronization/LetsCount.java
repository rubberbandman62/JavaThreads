package com.iks.threads.synchronization;

public class LetsCount {
	private static Class<CounterSimple> clazz = CounterSimple.class;
	
	private static boolean readingThreadRunning;

	public static void main(String[] args) {
		
		Counter counter1 = getInstance();

		Thread incrementThread = new Thread(() -> LetsCount.changeSharedObject(true, counter1));
		Thread decrementThread = new Thread(() -> LetsCount.changeSharedObject(false, counter1));
		Thread readingThread = new Thread(() -> LetsCount.readSharedObject(counter1));

		incrementThread.start();
//		System.out.println("increment thread on counter 1 started");

		decrementThread.start();
//		System.out.println("decrement thread on counter 1 started");
		
		readingThreadRunning = true;
		readingThread.start();
//		System.out.println("reading thread on counter 2 started");
		
		try {
			incrementThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			decrementThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		readingThreadRunning = false;
		
		try {
			readingThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(String.format("The first counter should be 0 and is %d", counter1.cValue()));
	}

	public static void changeSharedObject(boolean inc, Counter counter) {
		for (int i = 0; i < 1000; i++) {
			if (inc) {
				counter.increment();
			} else {
				counter.decrement();
			}
			try {
				Thread.sleep(0, 1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private static void readSharedObject(Counter counter) {
		while (readingThreadRunning) {
			System.out.println(counter.cValue());
		}
	}

	private static Counter getInstance() {
		Counter instance = null;
		try {
			instance = clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e1) {
			e1.printStackTrace();
		}
		return instance;
	}

}
