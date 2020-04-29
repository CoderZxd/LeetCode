package com.zxd.test.leetcode;

import com.sun.deploy.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @Title: PingTest
 * @Description: TODO
 * @Author xiaodong.zou
 * @Date 2020/4/28 16:50
 */
public class PingTest {

	public static void main(String[] args) {
		Properties properties = System.getProperties();
		System.out.println(properties.getProperty("os.name").toLowerCase().contains("windows"));

		System.out.println(getNetworkStatusByPing("ping -n 5 iotemqtest.luckincoffee.com"));
	}
	/**
	 * 通过ip获取信息,loss:丢包率，delay:延时
	 * @param cmd
	 * @return
	 */
	private static String getNetworkStatusByPing(String cmd){
		//获取当前进程运行对象
		Runtime runtime = Runtime.getRuntime();
		Process process = null;
		String line = null;
		InputStream inputStream = null;
		InputStreamReader isReader = null;
		BufferedReader reader = null;
		StringBuffer buffer = new StringBuffer("");
		try {
			process = runtime.exec(cmd);
			inputStream = process.getInputStream();//实例化输入流
			isReader = new InputStreamReader(inputStream,"GB2312");
			reader = new BufferedReader(isReader);
			while ((line = reader.readLine()) != null){
				buffer.append(line + "\r\n");
			}
		} catch (IOException e) {
		}finally {
			try {
				reader.close();
			}catch (Exception e){
			}
			try {
				isReader.close();
			}catch (Exception e){
			}
			try {
				inputStream.close();
			}catch (Exception e){
			}
		}
		return buffer.toString();
	}
}
