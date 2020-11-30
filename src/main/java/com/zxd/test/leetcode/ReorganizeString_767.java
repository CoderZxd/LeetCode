package com.zxd.test.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName ReorganizeString_767
 * @Description https://leetcode-cn.com/problems/reorganize-string/
 * @Author xiaodong.zou
 * @Date 2020/11/30 20:50
 * @Version 1.0
 */
//767. 重构字符串
//        给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
//
//        若可行，输出任意可行的结果。若不可行，返回空字符串。
//
//        示例 1:
//
//        输入: S = "aab"
//        输出: "aba"
//        示例 2:
//
//        输入: S = "aaab"
//        输出: ""
//        注意:
//
//        S 只包含小写字母并且长度在[1, 500]区间内。
public class ReorganizeString_767 {

    public static void main(String[] args) {

    }

    /**
     * 基于最大堆的贪心算法
     * @param S
     * @return
     */
    public String reorganizeString(String S) {
        int len = S.length();
        if(S.length()<2){
            return S;
        }
        int[] counts = new int[26];
        for(int i=0;i<len;i++){
            counts[S.charAt(i)-'a']++;
            if(counts[S.charAt(i)-'a']>(len+1)/2){
                return "";
            }
        }
        PriorityQueue<Character> queue = new PriorityQueue<Character>(new Comparator<Character>() {
            public int compare(Character letter1, Character letter2) {
                return counts[letter2 - 'a'] - counts[letter1 - 'a'];
            }
        });
        for (char c = 'a'; c <= 'z'; c++) {
            if (counts[c - 'a'] > 0) {
                queue.offer(c);
            }
        }
        StringBuffer sb = new StringBuffer();
        while (queue.size() > 1) {
            char letter1 = queue.poll();
            char letter2 = queue.poll();
            sb.append(letter1);
            sb.append(letter2);
            int index1 = letter1 - 'a', index2 = letter2 - 'a';
            counts[index1]--;
            counts[index2]--;
            if (counts[index1] > 0) {
                queue.offer(letter1);
            }
            if (counts[index2] > 0) {
                queue.offer(letter2);
            }
        }
        if (queue.size() > 0) {
            sb.append(queue.poll());
        }
        return sb.toString();
    }

}
