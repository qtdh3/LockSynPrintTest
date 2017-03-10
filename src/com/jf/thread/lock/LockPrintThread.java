package com.jf.thread.lock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;

public class LockPrintThread extends Thread {
	Lock lock;
	AtomicInteger countNum;
	String threadName;
	int needStateNum;
	
	
	
	public LockPrintThread(Lock lock, AtomicInteger countNum, String threadName,int needStateNum) {
		super();
		this.lock = lock;
		this.countNum = countNum;
		this.threadName = threadName;
		this.needStateNum=needStateNum;
	}



	public void run() {
		super.run();
		while (countNum.get()<50) {
			lock.lock();
			if (countNum.get()%3==needStateNum) {
				printMessage();
			}		
			lock.unlock();
		}		
	}
	
	private void printMessage(){
//		System.out.println(threadName+" 值打印："+countNum);
		int i=countNum.getAndIncrement();
		System.out.println(threadName+" 值打印："+i);
//		 i=countNum.getAndIncrement();
//		System.out.println(threadName+" 值打印："+i);
//		 i=countNum.getAndIncrement();
//		System.out.println(threadName+" 值打印："+i);
	}

}
