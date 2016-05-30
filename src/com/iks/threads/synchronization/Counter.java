package com.iks.threads.synchronization;

public interface Counter {
	public void reset();
	
	public void increment();

	public void decrement();

	public int cValue();
}
