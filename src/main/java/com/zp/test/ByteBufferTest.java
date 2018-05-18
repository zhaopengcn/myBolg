package com.zp.test;

import java.nio.ByteBuffer;

public class ByteBufferTest {
	static int count = 0;
	public static synchronized void add(int value){
		 count += value;
		 }
	public static void main(String[] args) {
		ByteBuffer byteBuffer = ByteBuffer.allocate(6);
		byteBuffer.put((byte)1);
		byteBuffer.put((byte)2);
		byteBuffer.put((byte)3);
		System.out.println(byteBuffer);
		
		byteBuffer.position(1);
		byteBuffer.limit(3);
		
		byte bt = byteBuffer.get();
		System.out.println(byteBuffer);
	}
}
