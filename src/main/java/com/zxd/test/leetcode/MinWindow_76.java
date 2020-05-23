package com.zxd.test.leetcode;

/**
 * @Title: MinWindow_76
 * @Description: https://leetcode-cn.com/problems/minimum-window-substring/
 * @Author xiaodong.zou
 * @Date 2020/5/23 11:02
 */

//76. 最小覆盖子串
//		给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
//
//		示例：
//
//		输入: S = "ADOBECODEBANC", T = "ABC"
//		输出: "BANC"
//		说明：
//
//		如果 S 中不存这样的子串，则返回空字符串 ""。
//		如果 S 中存在这样的子串，我们保证它是唯一的答案。
public class MinWindow_76 {


	public static void main(String[] args) {
		System.out.println(minWindow("cwirwjbfntstplnenpabdttnbiagcnrglbyhnbnavhvmtlqgaqkdmdtnltvpipwuquddvseqabctmsbmllsxrlmegjupyqlpmqsjlyalaegozjbkxtjogxsmgodhgqwsjqeureftknhlwixvdgjjfeyoudvburvdjzxafetqtbdplblrjwcpccdxgyyarvfaxcbciwubzysnzfekeizgledredrvzyyyazakxvlxvfkwlqgpyixjmbargtohrmftngfldskyywwlmccmkzwzayshugontwhicovfhffhbdsphucutatwalfutviorrxvhscoyhvbmntujvofxjbxwispdcexvdscvvtveozresnnpbsmmvjifdxlhdicgchexazcqavusikhlevxaffhkessicwqffuchugyudspncwahuxjzeslll","ftpejujeztahrwljlao"));
	}
	public static String minWindow(String s, String t) {
		if(s.equals(t)){
			return s;
		}
		int s_len = s.length();
		int t_len = t.length();
		int start = 0;
		int end = 0;
		String[] tArray = t.split("");
		label:
		for(int i=0;i<=s_len-t_len;i++){
			for(int j=s_len;j>=i+t_len;j--){
				String temp = s.substring(i,j);
				for(String ele:tArray){
					if(!temp.contains(ele)){
						continue label;
					}else{
						StringBuffer sb = new StringBuffer(temp).deleteCharAt(temp.indexOf(ele));
						temp = sb.toString();
					}
				}
				if(start==0 && end==0){
					start = i;
					end = j;
				}else if(j-i<end-start){
					start = i;
					end = j;
				}
			}
		}
		return s.substring(start,end);
	}


	public static String minWindow_2(String s, String t) {
		if(s.equals(t)){
			return s;
		}
		int s_len = s.length();
		int t_len = t.length();
		String result = "";
		for(int start=0;start<=s_len-t_len;start++){
			for (int end=start+t_len;end<s_len;end++){
				String temp = s.substring(start,end+1);
			}
		}
		return result;
	}
}
