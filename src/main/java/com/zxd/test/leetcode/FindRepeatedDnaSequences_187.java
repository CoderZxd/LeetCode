package com.zxd.test.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description https://leetcode-cn.com/problems/repeated-dna-sequences/
 * @Author zouxiaodong
 * @Date 2021/10/08 9:31
 */
//187. 重复的DNA序列
//        所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
//        编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
//
//
//        示例 1：
//        输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
//        输出：["AAAAACCCCC","CCCCCAAAAA"]

//        示例 2：
//        输入：s = "AAAAAAAAAAAAA"
//        输出：["AAAAAAAAAA"]
//
//
//        提示：
//        0 <= s.length <= 10^5
//        s[i] 为 'A'、'C'、'G' 或 'T'
public class FindRepeatedDnaSequences_187 {

    public static void main(String[] args) {

    }

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>(10);
        Map<String, Integer> cnt = new HashMap<>(16);
        int n = s.length();
        for (int i = 0; i <= n - 10; ++i) {
            String sub = s.substring(i, i + 10);
            cnt.put(sub, cnt.getOrDefault(sub, 0) + 1);
            if (cnt.get(sub) == 2) {
                ans.add(sub);
            }
        }
        return ans;
    }
}
