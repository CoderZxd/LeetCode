package com.zxd.test.leetcode;

/**
 * @Title: MySqrt_69
 * @Description: https://leetcode-cn.com/problems/sqrtx/
 * @Author xiaodong.zou
 * @Date 2020/5/9 9:25
 */
//69. x 的平方根
//		实现 int sqrt(int x) 函数。
//
//		计算并返回 x 的平方根，其中 x 是非负整数。
//
//		由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
//
//		示例 1:
//
//		输入: 4
//		输出: 2
//		示例 2:
//
//		输入: 8
//		输出: 2
//		说明: 8 的平方根是 2.82842...,
//		由于返回类型是整数，小数部分将被舍去。
public class MySqrt_69 {

	public static void main(String[] args) {
		System.out.println(mySqrt_2(2147395600));
	}

	/**
	 * 暴力破解
	 * @param x
	 * @return
	 */
	public static int mySqrt(int x) {
		int max = (int)Math.ceil(x/2);
		System.out.println("max:"+max);
		for(int i=1;i<=max;i++){
			if(((long)i*i)<=x && ((long)(i+1)*(i+1))>x){
				return i;
			}
		}
		return x;
	}

	/**
	 * 以下为官方解法
	 */
//	方法一：袖珍计算器算法
//「袖珍计算器算法」是一种用指数函数 \expexp 和对数函数 \lnln 代替平方根函数的方法。我们通过有限的可以使用的数学函数，得到我们想要计算的结果。
//
//	我们将 \sqrt{x}
//	x
//​
//	写成幂的形式 x^{1/2}x
//1/2
//		，再使用自然对数 ee 进行换底，即可得到
//
//\sqrt{x} = x^{1/2} = (e ^ {\ln x})^{1/2} = e^{\frac{1}{2} \ln x}
//	x
//​
//		=x
//1/2
//		=(e
//			lnx
// )
//		 1/2
//		 =e
//2
//		1
//		​
//	lnx
//
//
//	这样我们就可以得到 \sqrt{x}
//	x
//​
//	的值了。
//
//	注意： 由于计算机无法存储浮点数的精确值（浮点数的存储方法可以参考 IEEE 754，这里不再赘述），而指数函数和对数函数的参数和返回值均为浮点数，因此运算过程中会存在误差。例如当 x = 2147395600x=2147395600 时，e^{\frac{1}{2} \ln x}e
//2
//		1
//		​
//	lnx
//	的计算结果与正确值 4634046340 相差 10^{-11}10
//			−11
//			，这样在对结果取整数部分时，会得到 4633946339 这个错误的结果。
//
//	因此在得到结果的整数部分 \textit{ans}ans 后，我们应当找出 \textit{ans}ans 与 \textit{ans} + 1ans+1 中哪一个是真正的答案。
//
//	作者：LeetCode-Solution
//	链接：https://leetcode-cn.com/problems/sqrtx/solution/x-de-ping-fang-gen-by-leetcode-solution/
//	来源：力扣（LeetCode）
//	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
	public int mySqrt_1(int x) {
		if (x == 0) {
			return 0;
		}
		int ans = (int)Math.exp(0.5 * Math.log(x));
		return (long)(ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
	}

//	方法二：二分查找
//	由于 xx 平方根的整数部分 \textit{ans}ans 是满足 k^2 \leq xk
//2
//		≤x 的最大 kk 值，因此我们可以对 kk 进行二分查找，从而得到答案。
//
//	二分查找的下界为 00，上界可以粗略地设定为 xx。在二分查找的每一步中，我们只需要比较中间元素 \textit{mid}mid 的平方与 xx 的大小关系，并通过比较的结果调整上下界的范围。由于我们所有的运算都是整数运算，不会存在误差，因此在得到最终的答案 \textit{ans}ans 后，也就不需要再去尝试 \textit{ans} + 1ans+1 了。
//
//	作者：LeetCode-Solution
//	链接：https://leetcode-cn.com/problems/sqrtx/solution/x-de-ping-fang-gen-by-leetcode-solution/
//	来源：力扣（LeetCode）
//	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

	public static int mySqrt_2(int x) {
		int result = -1;
		int start = 0,end = x;
		while (start<=end){
			int mid = (end-start)/2+start;
			if((long)mid*mid<=x){
				result = mid;
				start = mid+1;
			}else{
				end=mid-1;
			}
		}
		return result;
	}
}
