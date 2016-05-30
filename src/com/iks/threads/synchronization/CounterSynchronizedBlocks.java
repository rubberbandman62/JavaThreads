package com.iks.threads.synchronization;

public class CounterSynchronizedBlocks implements Counter {
	private int c = 0;

	@Override
	public void reset() {
		synchronized (this) {
			c = 0;
		}
	}

	@Override
	public void increment() {
		synchronized (this) {
			c++;
		}
	}

	@Override
	public synchronized void decrement() {
		synchronized (this) {
			c--;
		}
	}

	@Override
	public int cValue() {
		return c;
	}

}
