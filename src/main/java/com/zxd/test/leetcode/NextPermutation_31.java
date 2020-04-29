package com.zxd.test.leetcode;

/**
 * @Title: NextPermutation_31
 * @Description: https://leetcode-cn.com/problems/next-permutation/
 * @Author xiaodong.zou
 * @Date 2020/4/29 9:11
 */
//31. 下一个排列
//		实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
//
//		如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
//
//		必须原地修改，只允许使用额外常数空间。
//
//		以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
//		1,2,3 → 1,3,2
//		3,2,1 → 1,2,3
//		1,1,5 → 1,5,1
//		1,3,2 → 2,1,3
//		2,3,1 → 3,1,2
//		5,4,7,5,3,2 → 5,5,2,3,4,7
//		4,2,0,2,3,2,0 → 4,2,0,3,0,2,2
public class NextPermutation_31 {

	public static void main(String[] args) {
//		nextPermutation(new int[]{4,2,0,2,3,2,0});
//		nextPermutation(new int[]{5,4,7,5,3,2});
//		nextPermutation(new int[]{1,3,2});
		nextPermutation(new int[]{2,3,1});
	}

	public static void nextPermutation(int[] nums) {
		if(nums != null && nums.length > 1){
			int len = nums.length;
			boolean swap = false;
			int maxPre = 0;
			int endIndex = len-1;
			for(int end=len-1;end >=0;end--){
				for(int pre=end-1;pre>=0;pre--){
					if(nums[pre]<nums[end]){
						swap = true;
						if(pre>maxPre){
							maxPre=pre;
							endIndex=end;
						}else if(pre == maxPre && nums[endIndex] > nums[end]){
							endIndex = end;
						}
					}
				}
			}
			System.out.println(maxPre+" "+endIndex);
			int tempVal = nums[endIndex];
			nums[endIndex] = nums[maxPre];
			nums[maxPre]=tempVal;
			//从pre+1开始的元素需要从小到大排序，冒泡排序
			for(int i=maxPre+1;i<len;i++){
				for(int j=maxPre+1;j<len-1;j++){
					if(nums[j+1]<nums[j]){
						int tempNum = nums[j+1];
						nums[j+1]=nums[j];
						nums[j]=tempNum;
					}
				}
			}
			//如果没有交换过，说明没有更大的排列,排列成最小排列(头尾两两交换)
			if(!swap){
				for(int end = len-1,start=0;start<end;start++,end--){
					int temp = nums[start];
					nums[start] = nums[end];
					nums[end] = temp;
				}
			}
		}
	}
}
