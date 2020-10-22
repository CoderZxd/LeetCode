package com.zxd.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description https://leetcode-cn.com/problems/partition-labels/
 * @Author zouxiaodong
 * @Date 2020/10/22 8:25
 */
//763. 划分字母区间
//        字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
//
//        示例 1：
//        输入：S = "ababcbacadefegdehijhklij"
//        输出：[9,7,8]
//        解释：
//        划分结果为 "ababcbaca", "defegde", "hijhklij"。
//        每个字母最多出现在一个片段中。
//        像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
//
//
//        提示：
//        S的长度在[1, 500]之间。
//        S只包含小写字母 'a' 到 'z' 。
public class PartitionLabels_763 {

    public static void main(String[] args) {
        PartitionLabels_763 partitionLabels_763 = new PartitionLabels_763();
        System.out.println(partitionLabels_763.partitionLabels("ababcbacadefegdehijhklij"));
        System.out.println(partitionLabels_763.partitionLabels_1("ababcbacadefegdehijhklij"));

    }

    public List<Integer> partitionLabels(String S) {
        List<Integer> resultList = new ArrayList<>(10);
        int len = S.length();
        for(int i=0;i<len;){
            int index = S.lastIndexOf(S.charAt(i));
            if(index == len){
                resultList.add(len-index+1);
                return resultList;
            }
            for(int j=i+1;j<index;j++){
                int lastIndexJ = S.lastIndexOf(S.charAt(j));
                if(lastIndexJ > index){
                    index = lastIndexJ;
                }
            }
            resultList.add(index-i+1);
            i = index + 1;
        }
        return resultList;
    }

    /**
     * @Author zouxiaodong
     * @Description 贪心算法
     * @Date 2020/10/22 9:34
     * @Param [S]
     * @return java.util.List<java.lang.Integer>
     **/
    public List<Integer> partitionLabels_1(String S) {
        int[] last = new int[26];
        int length = S.length();
        for (int i = 0; i < length; i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<Integer>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            end = Math.max(end, last[S.charAt(i) - 'a']);
            //精髓所在
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }
}
