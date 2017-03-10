package com.jf.thread.lock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTestMain {

	public static void main(String[] args) {
		System.out.println("主线程入口");
		Lock lock =new ReentrantLock(true);
		AtomicInteger countNum=new AtomicInteger(1);
		LockPrintThread threadA=new LockPrintThread(lock, countNum, "线程A", 1);
		LockPrintThread threadB=new LockPrintThread(lock, countNum, "线程B", 2);
		LockPrintThread threadC=new LockPrintThread(lock, countNum, "线程C", 0);
		threadA.start();
		threadB.start();
		threadC.start();
		
	}

}
