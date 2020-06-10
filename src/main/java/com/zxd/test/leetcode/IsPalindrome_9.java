package com.zxd.test.leetcode;

/**
 * @Title: IsPalindrome_9
 * @Description: https://leetcode-cn.com/problems/palindrome-number/
 * @Author xiaodong.zou
 * @Date 2020/6/10 9:07
 */
//
//9. 回文数
//		判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
//
//		示例 1:
//
//		输入: 121
//		输出: true
//		示例 2:
//
//		输入: -121
//		输出: false
//		解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
//		示例 3:
//
//		输入: 10
//		输出: false
//		解释: 从右向左读, 为 01 。因此它不是一个回文数。
//		进阶:
//
//		你能不将整数转为字符串来解决这个问题吗？
public class IsPalindrome_9 {

	public static void main(String[] args) {
		System.out.println(isPalindrome(4312134));
		System.out.println(isPalindrome(-121));
		System.out.println(isPalindrome(10));
		System.out.println(isPalindrome(0));
		isPalindrome_1(4312134);
	}

	/**
	 * 不将整数转为字符串来解决
	 * @param x
	 * @return
	 */
	public static boolean isPalindrome_1(int x) {
		if(x<0 || (x % 10 == 0 && x != 0)){
			return false;
		}
		int result = x;
		int mod = 0;
		int reverseX = 0;
		do{
			mod = result%10;
			result = result/10;
			reverseX=reverseX*10+mod;
		}while (result>0);
		if(reverseX == x){
			return true;
		}
		return false;
	}

	/**
	 * 将整数转为字符串来解决
	 * @param x
	 * @return
	 */
	public static boolean isPalindrome(int x) {
		String num = Integer.toString(x);
		int len = num.length();
		for(int i=0,j=len-1;i<j;i++,j--){
			if(num.charAt(i) != num.charAt(j)){
				return false;
			}
		}
		return true;
	}

	/**
	 * 方法一：反转一半数字
	 * @param x
	 * @return
	 */
//	方法一：反转一半数字
//			思路
//
//	映入脑海的第一个想法是将数字转换为字符串，并检查字符串是否为回文。但是，这需要额外的非常量空间来创建问题描述中所不允许的字符串。
//
//	第二个想法是将数字本身反转，然后将反转后的数字与原始数字进行比较，如果它们是相同的，那么这个数字就是回文。
//	但是，如果反转后的数字大于int.MAX，我们将遇到整数溢出问题。
//
//	按照第二个想法，为了避免数字反转可能导致的溢出问题，为什么不考虑只反转int 数字的一半？毕竟，如果该数字是回文，其后半部分反转后应该与原始数字的前半部分相同。
//
//	例如，输入 1221，我们可以将数字 “1221” 的后半部分从 “21” 反转为 “12”，并将其与前半部分 “12” 进行比较，因为二者相同，我们得知数字 1221 是回文。
//
//	算法
//
//	首先，我们应该处理一些临界情况。所有负数都不可能是回文，例如：-123 不是回文，因为 - 不等于 3。所以我们可以对所有负数返回 false。除了 0 以外，所有个位是 0 的数字不可能是回文，因为最高位不等于 0。所以我们可以对所有大于 0 且个位是 0 的数字返回 false。
//
//	现在，让我们来考虑如何反转后半部分的数字。
//
//	对于数字 1221，如果执行 1221 % 10，我们将得到最后一位数字 1，要得到倒数第二位数字，我们可以先通过除以 10 把最后一位数字从 1221 中移除，1221 / 10 = 122，再求出上一步结果除以 10 的余数，122 % 10 = 2，就可以得到倒数第二位数字。如果我们把最后一位数字乘以 10，再加上倒数第二位数字，1 * 10 + 2 = 12，就得到了我们想要的反转后的数字。如果继续这个过程，我们将得到更多位数的反转数字。
//
//	现在的问题是，我们如何知道反转数字的位数已经达到原始数字位数的一半？
//
//	由于整个过程我们不断将原始数字除以 10，然后给反转后的数字乘上 10，所以，当原始数字小于或等于反转后的数字时，就意味着我们已经处理了一半位数的数字了。
//
//	复杂度分析
//
//	时间复杂度：O(logn)，对于每次迭代，我们会将输入除以 10，因此时间复杂度为O(logn)。
//	空间复杂度：O(1)。我们只需要常数空间存放若干变量。
	public boolean isPalindrome_2(int x) {
		// 特殊情况：
		// 如上所述，当 x < 0 时，x 不是回文数。
		// 同样地，如果数字的最后一位是 0，为了使该数字为回文，
		// 则其第一位数字也应该是 0
		// 只有 0 满足这一属性
		if (x < 0 || (x % 10 == 0 && x != 0)) {
			return false;
		}

		int revertedNumber = 0;
		while (x > revertedNumber) {
			revertedNumber = revertedNumber * 10 + x % 10;
			x /= 10;
		}

		// 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
		// 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
		// 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
		return x == revertedNumber || x == revertedNumber / 10;
	}

}
