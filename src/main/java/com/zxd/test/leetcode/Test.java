package com.zxd.test.leetcode;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Title: Test
 * @Description: TODO
 * @Author xiaodong.zou
 * @Date 2020/6/3 16:29
 */
public class Test {

	public static void main(String[] args) throws ParseException {
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

		String time = "2019-08-06T14:40:00Z";
		time = time.replaceAll("T"," ").replaceAll("Z","");
		SimpleDateFormat dateFm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //格式化当前系统日期
		String dateTime = dateFm.format(new java.util.Date());
		Date parse = dateFm.parse(time);
		System.out.println(dateTime);
	}

}
