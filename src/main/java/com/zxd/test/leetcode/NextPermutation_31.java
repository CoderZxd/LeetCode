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

	/**
	 * 找出距离尾部最近的需要交换的位置，如果有相同的最近的交换位置，则需要判断需要交换位置对应的两个数，取较小的对应数字的位置(因为情况1与情况2，pre相同,需要取nums[end1]<nums[end2]的条件下的end1值),例如:
	 *  4,2,0,2,3,2,0
	 *      ↑     ↑
	 *情况1 pre   end
	 *      ↑   ↑
	 *情况2 pre end
	 *这种情况应该取情况1
	 * @param nums
	 */
	public static void nextPermutation(int[] nums) {
		//如果nums长度大于1
		if(nums != null && nums.length > 1){
			int len = nums.length;
			//是否需要数据交换，如果需要数据交换，需要做数据交换后的重排序处理，否则就需要把数组进行原地倒排
			boolean swap = false;
			//最靠近尾部的需要交换的位置，只有这样，才是下一个更大的排列
			int maxPre = 0;
			//需要与maxpre进行数据互换位置的数的位置
			int endIndex = -1;
			//双循环找出最大的maxpre和数据最小的endIndex
			for(int end=len-1;end >=0;end--){
				for(int pre=end-1;pre>=0;pre--){
					//如果pre<end 就代表存在更大的排列,swap就可以为true
					if(nums[pre]<nums[end]){
						swap = true;
						if(endIndex < 0){
							endIndex = end;
						}
						//如果当前的pre>maxPre,说明存在更靠近尾部的下一个更大排列
						if(pre>maxPre){
							maxPre=pre;
							endIndex=end;
						}else if(pre == maxPre && nums[endIndex] > nums[end]){ //如果当前pre与maxPre相同,并且end小于endIndex，说明这种情况比endIndex更小，更接近下一个更大排列，所以需要将endIndex值更新为当前的end
							endIndex = end;
						}
					}
				}
			}
			//如果存在更大的排列，则交换maxPre与endIdex的值,然后maxPre+1到len-1的元素进行有小到大排序
			if(swap){
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
