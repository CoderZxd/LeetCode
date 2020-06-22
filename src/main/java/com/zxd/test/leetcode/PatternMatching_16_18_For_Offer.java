package com.zxd.test.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title: PatternMatching_16_18_For_Offer
 * @Description: https://leetcode-cn.com/problems/pattern-matching-lcci/
 * @Author xiaodong.zou
 * @Date 2020/6/22 9:17
 */
//面试题 16.18. 模式匹配
//		你有两个字符串，即pattern和value。 pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式。
//		例如，字符串"catcatgocatgo"匹配模式"aabab"（其中"cat"是"a"，"go"是"b"），该字符串也匹配像"a"、"ab"和"b"这样的模式。
//		但需注意"a"和"b"不能同时表示相同的字符串。编写一个方法判断value字符串是否匹配pattern字符串。
//
//		示例 1：
//
//		输入： pattern = "abba", value = "dogcatcatdog"
//		输出： true
//		示例 2：
//
//		输入： pattern = "abba", value = "dogcatcatfish"
//		输出： false
//		示例 3：
//
//		输入： pattern = "aaaa", value = "dogcatcatdog"
//		输出： false
//		示例 4：
//
//		输入： pattern = "abba", value = "dogdogdogdog"
//		输出： true
//		解释： "a"="dogdog",b=""，反之也符合规则
//		提示：
//
//		0 <= len(pattern) <= 1000
//		0 <= len(value) <= 1000
//		你可以假设pattern只包含字母"a"和"b"，value仅包含小写字母。
public class PatternMatching_16_18_For_Offer {

	public static void main(String[] args) {
		PatternMatching_16_18_For_Offer patternMatching = new PatternMatching_16_18_For_Offer();
//		System.out.println(patternMatching.patternMatching("abba","dogcatcatdog"));
//		System.out.println(patternMatching.patternMatching("abba","dogcatcatfish"));
//		System.out.println(patternMatching.patternMatching("aaaa","dogcatcatdog"));
		System.out.println(patternMatching.patternMatching("ab",""));
	}

	public boolean patternMatching(String pattern, String value) {
		int lenPattern = pattern.length();
		int lenValue = value.length();
		//如果pattern与value都为空,返回true
		if(lenPattern == 0 && lenValue == 0){
			return true;
		}
		//如果pattern为空,value不为空,返回false
		if(lenPattern == 0 && lenValue != 0){
			return false;
		}
		//1.pattern只有a或者b
		if(pattern.indexOf("a") == -1 || pattern.indexOf("b") == -1){
			//如果value的长度不是pattern的整数倍，则说明不匹配
			if(lenValue%lenPattern != 0){
				return false;
			}
			return patternMatchingForReplaceChar("",pattern,value);
		}
		//如果pattern不为空,value却为空,返回false
		if(lenValue == 0){
			return false;
		}
		//2.pattern包括a和b
		//如果a和b有一个为空串，判断是否满足
		//全部替换a为""或者b为""
		if(patternMatchingForReplaceChar("a",pattern,value) || patternMatchingForReplaceChar("b",pattern,value)){
			return true;
		}
		//3.a和b都不为""
		//统计a与b的个数(二元一次方程求解,countA*a+countB*b=lenValue)
		String[] patternArray = pattern.split("");
		int length = patternArray.length;
		int count_a = 0;
		int count_b = 0;
		for(int i=0;i<length;i++){
			if("a".equals(patternArray[i])){
				count_a++;
			}else{
				count_b++;
			}
		}
//		System.out.println("count_a="+count_a+",count_b="+count_b);
		//找到a字符长度最大值和b字符长度最大值
		int maxA = (lenValue-count_b)/count_a;
		int maxB = (lenValue-count_a)/count_b;
//		System.out.println("maxA="+maxA+",maxB="+maxB);
		label:
		for(int a=1;a<=maxA;a++){
			if((lenValue-count_a*a)%count_b == 0){
				int b = (lenValue-count_a*a)/count_b;
				int start = 0;
				String word_a = "";
				String word_b = "";
				for(int i=0;i<length;i++){
					if("a".equals(patternArray[i])){
						if("".equals(word_a)){
							word_a = value.substring(start,start+a);
						}else{
							String temp_word_a = value.substring(start,start+a);
							if(!word_a.equals(temp_word_a)){
								continue label;
							}
						}
						start += word_a.length();
					}else{
						if("".equals(word_b)){
							word_b = value.substring(start,start+b);
						}else{
							String temp_word_b = value.substring(start,start+b);
							if(!word_b.equals(temp_word_b)){
								continue label;
							}
						}
						start += word_b.length();
					}
				}
				return true;
			}
		}
		return false;
	}

	/**
	 * 将pattern中的c替换成"",然后判断pattern是否与value匹配
	 * @param c
	 * @param pattern
	 * @param value
	 * @return
	 */
	private boolean patternMatchingForReplaceChar(String c,String pattern,String value){
		String newPattern = pattern.replaceAll(c,"");
		int newLenPattern = newPattern.length();
		int lenValue = value.length();
		if(lenValue%newLenPattern == 0){
			int wordLength = lenValue/newLenPattern;
			String word=value.substring(0,wordLength);
			for(int i=1;i<newLenPattern;i++){
				String tempWord = value.substring(i*wordLength,(i+1)*wordLength);
				if(!word.equals(tempWord)){
					return false;
				}
			}
		}else{
			return false;
		}
		return true;
	}
}
