package com.zxd.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName RestoreIpAddresses_93
 * @Description https://leetcode-cn.com/problems/restore-ip-addresses/
 * @Author xiaodong.zou
 * @Date 2020/8/9 16:53
 * @Version 1.0
 */
//93. 复原IP地址
//        给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
//        有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
//
//        示例:
//        输入: "25525511135"
//        输出: ["255.255.11.135", "255.255.111.35"]
public class RestoreIpAddresses_93 {

    public static void main(String[] args) {

    }

    static final int SEG_COUNT = 4;
    List<String> ans = new ArrayList<String>();
    int[] segments = new int[SEG_COUNT];

//    方法一：递归
//            思路与算法
//
//    由于我们需要找出所有可能复原出的 IP 地址，因此可以考虑使用递归的方法，对所有可能的字符串分隔方式进行搜索，并筛选出满足要求的作为答案。
//
//    设题目中给出的字符串为 s。我们用递归函数 dfs(segId,segStart) 表示我们正在从s[segStart] 的位置开始，搜索 IP 地址中的第segId 段，其中segId∈{0,1,2,3}。
//    由于 IP 地址的每一段必须是[0,255] 中的整数，因此我们从segStart 开始，从小到大依次枚举当前这一段 IP 地址的结束位置segEnd。
//    如果满足要求，就递归地进行下一段搜索，调用递归函数dfs(segId+1,segEnd+1)。
//
//    特别地，由于 IP 地址的每一段不能有前导零，因此如果 s[segStart] 等于字符 0，那么 IP 地址的第 segId 段只能为 0，需要作为特殊情况进行考虑。
//
//    在递归搜索的过程中，如果我们已经得到了全部的 4 段 IP 地址（即segId=4），并且遍历完了整个字符串（即 segStart=∣s∣，其中 |s|表示字符串 s的长度），
//    那么就复原出了一种满足题目要求的 IP 地址，我们将其加入答案。在其它的时刻，如果提前遍历完了整个字符串，那么我们需要结束搜索，回溯到上一步。
    public List<String> restoreIpAddresses(String s) {
        segments = new int[SEG_COUNT];
        dfs(s, 0, 0);
        return ans;
    }

    public void dfs(String s, int segId, int segStart) {
        // 如果找到了 4 段 IP 地址并且遍历完了字符串，那么就是一种答案
        if (segId == SEG_COUNT) {
            if (segStart == s.length()) {
                StringBuffer ipAddr = new StringBuffer();
                for (int i = 0; i < SEG_COUNT; ++i) {
                    ipAddr.append(segments[i]);
                    if (i != SEG_COUNT - 1) {
                        ipAddr.append('.');
                    }
                }
                ans.add(ipAddr.toString());
            }
            return;
        }

        // 如果还没有找到 4 段 IP 地址就已经遍历完了字符串，那么提前回溯
        if (segStart == s.length()) {
            return;
        }

        // 由于不能有前导零，如果当前数字为 0，那么这一段 IP 地址只能为 0
        if (s.charAt(segStart) == '0') {
            segments[segId] = 0;
            dfs(s, segId + 1, segStart + 1);
        }

        // 一般情况，枚举每一种可能性并递归
        int addr = 0;
        for (int segEnd = segStart; segEnd < s.length(); ++segEnd) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if (addr > 0 && addr <= 0xFF) {
                segments[segId] = addr;
                dfs(s, segId + 1, segEnd + 1);
            } else {
                break;
            }
        }
    }
}
