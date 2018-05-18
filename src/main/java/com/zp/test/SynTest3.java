package com.zp.test;
import java.util.concurrent.TimeUnit;

public class SynTest3 {
    static int count;
    public synchronized void add(int value){
    	 try {
			TimeUnit.SECONDS.sleep(value);
			count += value;
			System.out.println(Thread.currentThread().getName() + " sleepped "+ value +"s" +";count:"+count);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
 
    public static void main(String[] args) {
       final SynTest3 rs1 = new SynTest3();
       final SynTest3 rs2 = new SynTest3();
       final SynTest3 rs3 = new SynTest3();
 
       new Thread() {
           public void run() {
              rs1.add(3);
           }
       }.start();
       new Thread() {
           public void run() {
              rs2.add(2);
           }
       }.start();
       new Thread() {
           public void run() {
              rs3.add(1);
           }
       }.start();
    }
}
