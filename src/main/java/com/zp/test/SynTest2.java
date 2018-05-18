package com.zp.test;
import java.util.concurrent.TimeUnit;

public class SynTest2 {
	private Object syncObject1 = new Object();
    private Object syncObject2 = new Object();
 
    public void f() {
       // other operations should not be locked...
       System.out.println(Thread.currentThread().getName()
              + ":not synchronized in f()");
       synchronized (this) {
           for (int i = 0; i < 5; i++) {
              System.out.println(Thread.currentThread().getName()
                     + ":synchronized in f()");
              try {
                  TimeUnit.SECONDS.sleep(3);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
           }
       }
    }
 
    public void g() {
       // other operations should not be locked...
       System.out.println(Thread.currentThread().getName()
              + ":not synchronized in g()");
       synchronized (syncObject1) {
           for (int i = 0; i < 5; i++) {
              System.out.println(Thread.currentThread().getName()
                     + ":synchronized in g()");
              try {
                  TimeUnit.SECONDS.sleep(3);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
           }
       }
    }
 
    public void h() {
       // other operations should not be locked...
       System.out.println(Thread.currentThread().getName()
              + ":not synchronized in h()");
       synchronized (syncObject2) {
           for (int i = 0; i < 5; i++) {
              System.out.println(Thread.currentThread().getName()
                     + ":synchronized in h()");
              try {
                  TimeUnit.SECONDS.sleep(3);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
           }
       }
    }
 
    public static void main(String[] args) {
       final SynTest2 rs = new SynTest2();
 
       new Thread() {
           public void run() {
              rs.f();
           }
       }.start();
 
       new Thread() {
           public void run() {
              rs.g();
           }
       }.start();
 
       rs.h();
    }
}
