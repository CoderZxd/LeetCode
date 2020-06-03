package com.zxd.test.leetcode;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Title: Test
 * @Description: TODO
 * @Author xiaodong.zou
 * @Date 2020/6/3 16:29
 */
public class Test {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
//		calendar.add(Calendar.DAY_OF_MONTH,1);
//		calendar.set(Calendar.HOUR_OF_DAY,7);
		calendar.add(Calendar.MINUTE,1);
		System.out.println(calendar.getTime());
		new Timer("get-spce-cleaning-status-timer").schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("==========================>>>>>>>>>>>>>>");
			}
		},calendar.getTime(),30*1000L);
	}

}
