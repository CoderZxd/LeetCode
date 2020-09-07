package com.zxd.test.leetcode;

import java.util.*;

/**
 * @Description https://leetcode-cn.com/problems/top-k-frequent-elements/
 * @Author zouxiaodong
 * @Date 2020/09/07 8:06
 */
//347. 前 K 个高频元素
//        给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
//
//        示例 1:
//        输入: nums = [1,1,1,2,2,3], k = 2
//        输出: [1,2]

//        示例 2:
//        输入: nums = [1], k = 1
//        输出: [1]
//
//        提示：
//        你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
//        你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
//        题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
//        你可以按任意顺序返回答案。
public class TopKFrequent_347 {

    public static void main(String[] args) {
        TopKFrequent_347 topKFrequent = new TopKFrequent_347();
//        topKFrequent.topKFrequent(new int[]{1,1,1,2,2,3},2);
        topKFrequent.topKFrequent(new int[]{1},1);
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> numsMap = new HashMap<>(nums.length*2);
        for(Integer num:nums){
            Integer value = numsMap.get(num);
            if (value == null) {
                numsMap.put(num, 1);
            } else {
                numsMap.put(num, value + 1);
            }
        }
        List<KeyToNums> keyToNumsList = new ArrayList<>(numsMap.size());
        for(Map.Entry<Integer,Integer> entry:numsMap.entrySet()){
            keyToNumsList.add(new KeyToNums(entry.getKey(),entry.getValue()));
        }
        Collections.sort(keyToNumsList);
        int[] result = new int[k];
        for(int i = 0;i<k;i++){
            result[i] = keyToNumsList.get(i).key;
        }
        return result;
    }

    class KeyToNums implements Comparable<KeyToNums>{
        private Integer key;

        private Integer nums;

        public KeyToNums(Integer key, Integer nums) {
            this.key = key;
            this.nums = nums;
        }

        public Integer getKey() {
            return key;
        }

        public void setKey(Integer key) {
            this.key = key;
        }

        public Integer getNums() {
            return nums;
        }

        public void setNums(Integer nums) {
            this.nums = nums;
        }

        @Override
        public int compareTo(KeyToNums o) {
            return o.nums - this.nums;
        }
    }
}
