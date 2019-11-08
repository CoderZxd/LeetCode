package com.zxd.test.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Title: LengthOfLongestSubstring_3
 * @Description: 3. 无重复字符的最长子串
 * @Author xiaodong.zou
 * @Date 2019/11/8 14:27
 */
//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
//		示例 1:
//
//		输入: "abcabcbb"
//		输出: 3
//		解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//		示例 2:
//
//		输入: "bbbbb"
//		输出: 1
//		解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//		示例 3:
//
//		输入: "pwwkew"
//		输出: 3
//		解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//		     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
//		来源：力扣（LeetCode）
//		链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
//		著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class LengthOfLongestSubstring_3 {

	public static int lengthOfLongestSubstring(String s) {
		int result = 0;
		if(s != null && !"".equals(s)){
			String[] charArray = s.split("");
			Set<String> cacheSet = new HashSet<>(16);
			int length = charArray.length;
			for(int i=0;i<length;i++){
				cacheSet.add(charArray[i]);
				for(int j=i+1;j<length;j++){
					if(!cacheSet.add(charArray[j])){
						if(cacheSet.size()>result){
							result = cacheSet.size();
						}
						cacheSet.clear();
						break;
					}else{
						if(j-i+1>result){
							System.out.println(i+" "+j);
							result = j-i+1;
						}
					}
				}
			}
			if(cacheSet.size()>result){
				result = cacheSet.size();
			}
		}
		return result;
	}

	public static int lengthOfLongestSubstring2(String s) {
		if(null == s || "".equals(s)){
			return 0;
		}
		if(s.length() == 1){
			return 1;
		}
		int returnValue = 1;
		for(int i=0;i<s.length()-1;i++){
			for(int j=i+1;j < s.length();j++){
				if(s.substring(i,j).indexOf(s.charAt(j)) >= 0){
					if(j-i > returnValue){
						returnValue = j - i;
					}
					break;
				}else {
					if(j-i+1>returnValue){
						returnValue = j-i+1;
					}
				}
			}
		}
		return returnValue;
	}
//
//	使用 HashSet 将字符存储在当前窗口 [i, j)（最初 j = i）中。 然后我们向右侧滑动索引 j，如果它不在 HashSet 中，我们会继续滑动 j。
//	直到 s[j] 已经存在于 HashSet 中。此时，我们找到的没有重复字符的最长子字符串将会以索引 i 开头。如果我们对所有的 i这样做，就可以得到答案。
//	复杂度分析
//
//	时间复杂度：O(2n) = O(n)，在最糟糕的情况下，每个字符将被 i 和 j 访问两次。
//
//	空间复杂度：O(min(m, n))，与之前的方法相同。滑动窗口法需要 O(k) 的空间，其中 k 表示 Set 的大小。而 Set 的大小取决于字符串 n 的大小以及字符集 / 字母 m的大小。
	public static int lengthOfLongestSubstring3(String s) {
		int n = s.length();
		Set<Character> set = new HashSet<>();
		int ans = 0, i = 0, j = 0;
		while (i < n && j < n) {
			// try to extend the range [i, j]
			if (!set.contains(s.charAt(j))){
				set.add(s.charAt(j++));
				ans = Math.max(ans, j - i);
			}
			else {
				set.remove(s.charAt(i++));
			}
		}
		return ans;
	}


//	方法三：优化的滑动窗口
//	上述的方法最多需要执行 2n 个步骤。事实上，它可以被进一步优化为仅需要 n 个步骤。我们可以定义字符到索引的映射，而不是使用集合来判断一个字符是否存在。 当我们找到重复的字符时，我们可以立即跳过该窗口。
//
//	也就是说，如果 s[j]在 [i, j)范围内有与 j'
//			′
//	重复的字符，我们不需要逐渐增加 ii 。 我们可以直接跳过 [i，j']范围内的所有元素，并将 ii变为 j' + 1
//
//	复杂度分析
//
//	时间复杂度：O(n)，索引 j 将会迭代 n次。
//
//	空间复杂度（HashMap）：O(min(m, n))，与之前的方法相同。
//
//	空间复杂度（Table）：O(m)，m是字符集的大小。


	public static int lengthOfLongestSubstring4(String s) {
		int n = s.length(), ans = 0;
		Map<Character, Integer> map = new HashMap<>(); // current index of character
		// try to extend the range [i, j]
		for (int j = 0, i = 0; j < n; j++) {
			if (map.containsKey(s.charAt(j))) {
				i = Math.max(map.get(s.charAt(j)), i);
			}
			ans = Math.max(ans, j - i + 1);
			map.put(s.charAt(j), j + 1);
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring3("abcabcabcccc"));
	}
}
