package com.zxd.test.leetcode;

import java.util.*;

/**
 * @Title: FindWords_500
 * @Description: https://leetcode-cn.com/problems/keyboard-row/
 * @Author xiaodong.zou
 * @Date 2020/6/30 14:30
 */
//500. 键盘行
//		给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。
//      QWERTYUIOP
//	    ASDFGHJKL
//	    ZXCVBNM
//
//
//		American keyboard
//
//
//
//		示例：
//
//		输入: ["Hello", "Alaska", "Dad", "Peace"]
//		输出: ["Alaska", "Dad"]
//
//
//		注意：
//
//		你可以重复使用键盘上同一字符。
//		你可以假设输入的字符串将只包含字母。
public class FindWords_500 {

	public static void main(String[] args) {
		FindWords_500 findWords = new FindWords_500();
		findWords.findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"});
	}

	public String[] findWords(String[] words) {
		int len = words.length;
		if(len == 0){
			return new String[0];
		}
		Set<String> line_one = new HashSet<>(16);
		line_one.addAll(Arrays.asList("qwertyuiop".split("")));
		Set<String> line_two = new HashSet<>(16);
		line_two.addAll(Arrays.asList("asdfghjkl".split("")));
		Set<String> line_three = new HashSet<>(16);
		line_three.addAll(Arrays.asList("zxcvbnm".split("")));
		List<String> resultList = new ArrayList<>();
		for(String word:words){
			if(line_one.containsAll(Arrays.asList(word.toLowerCase().split("")))){
				resultList.add(word);
				continue;
			}
			if(line_two.containsAll(Arrays.asList(word.toLowerCase().split("")))){
				resultList.add(word);
				continue;
			}
			if(line_three.containsAll(Arrays.asList(word.toLowerCase().split("")))){
				resultList.add(word);
				continue;
			}
		}
		String[] result = new String[resultList.size()];
		resultList.toArray(result);
		return result;
	}
}
