package com.zxd.test.leetcode;

/**
 * @Title: VolatileVisibilityTest
 * @Description: TODO
 * @Author xiaodong.zou
 * @Date 2020/5/19 18:14
 */
public class VolatileVisibilityTest {

//	private static volatile boolean flag = false;
	private static boolean flag = false;

	public static void main(String[] args) throws InterruptedException {
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("waiting data.....");
				while (!flag){
//					try {
//						Thread.sleep(10L);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
				}
				System.out.println("=========================success");
			}
		}).start();

		Thread.sleep(2000L);

		new Thread(new Runnable() {

			@Override public void run() {
				System.out.println("setting data.....");
				flag=true;
				System.out.println("setting data success........");
			}
		}).start();
	}

}
