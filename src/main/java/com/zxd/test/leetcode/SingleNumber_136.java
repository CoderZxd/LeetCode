package com.zxd.test.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title: SingleNumber_136
 * @Description: https://leetcode-cn.com/problems/single-number/
 * @Author xiaodong.zou
 * @Date 2020/5/14 14:13
 */
//136. 只出现一次的数字
//		给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
//
//		说明：
//
//		你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
//
//		示例 1:
//
//		输入: [2,2,1]
//		输出: 1
//		示例 2:
//
//		输入: [4,1,2,1,2]
//		输出: 4
public class SingleNumber_136 {

	public static void main(String[] args) {
		System.out.println(singleNumber(new int[]{4,1,2,1,2}));
	}

	public static int singleNumber(int[] nums) {
		Map<Integer,Integer> tempMap = new HashMap<>(16);
		for(Integer ele:nums){
			if(tempMap.get(ele) != null){
				tempMap.remove(ele);
			}else{
				tempMap.put(ele,ele);
			}
		}
		return tempMap.keySet().iterator().next();
	}

//	可使用异或运算⊕。异或运算有以下三个性质。
//
//	任何数和 0 做异或运算，结果仍然是原来的数，即a⊕0=a。
//	任何数和其自身做异或运算，结果是 0，即a⊕a=0。
//	异或运算满足交换律和结合律，即a⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b。
	public static int singleNumber_2(int[] nums) {
		int result = 0;
		for(int ele:nums){
			result ^= ele;
		}
		return result;
	}
}
