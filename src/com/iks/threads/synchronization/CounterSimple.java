package com.iks.threads.synchronization;

public class CounterSimple implements Counter {
	private int c = 0;

	@Override
	public void reset() {
		c = 0;
	}

	@Override
	public void increment() {
		c++;
	}

	@Override
	public void decrement() {
		c--;
	}

	@Override
	public int cValue() {
		return c;
	}
}