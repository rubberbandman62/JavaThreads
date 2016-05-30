package com.iks.threads.synchronization;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterAtomic implements Counter {
	private AtomicInteger c = new AtomicInteger(0);

	@Override
	public void reset() {
		c.set(0);
	}
	
	@Override
	public void increment() {
		c.getAndIncrement();
	}

	@Override
	public void decrement() {
		c.getAndDecrement();
	}

	@Override
	public int cValue() {
		return c.get();
	}
}
