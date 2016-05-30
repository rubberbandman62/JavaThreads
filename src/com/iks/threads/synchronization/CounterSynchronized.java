package com.iks.threads.synchronization;

public class CounterSynchronized implements Counter {
	private int c = 0;

	@Override
	public synchronized void reset() {
		c = 0;
	}

	@Override
	public synchronized void increment() {
		c++;
	}

	@Override
	public synchronized void decrement() {
		c--;
	}

	@Override
	public int cValue() {
		return c;
	}
}
