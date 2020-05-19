package com.zxd.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: HeapTest
 * @Description: TODO
 * @Author xiaodong.zou
 * @Date 2020/5/19 16:42
 */
public class HeapTest {

	byte[] a = new byte[1024*100]; //100KB

	public static void main(String[] args) throws InterruptedException {
		List<HeapTest> testList = new ArrayList<>(10);
		while (true){
			testList.add(new HeapTest());
			Thread.sleep(10L);
		}
	}
}
