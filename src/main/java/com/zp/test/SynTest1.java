package com.zp.test;
import java.util.concurrent.TimeUnit;

public class SynTest1 {
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
       synchronized (this) {
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
       synchronized (this) {
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
       final SynTest1 rs = new SynTest1();
 
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
