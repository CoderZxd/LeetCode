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

    }

    public List<Integer> partitionLabels(String S) {
        List<Integer> resultList = new ArrayList<>(10);
        int len = S.length();
        for(int i=0;i<len;){
            char tempChar = S.charAt(i);
            int index = S.lastIndexOf(tempChar);
            if(index == len){
                resultList.add(len-index+1);
                return resultList;
            }
            for(int j=i+1;j<index;j++){
                char tempJ = S.charAt(j);
                int lastIndexJ = S.lastIndexOf(tempJ);
                if(lastIndexJ > index){
                    index = lastIndexJ;
                }
            }
            resultList.add(index-i+1);
            i=index+1;
        }
        return resultList;
    }
}
