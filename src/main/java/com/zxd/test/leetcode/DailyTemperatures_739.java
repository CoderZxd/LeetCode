package com.zxd.test.leetcode;

import java.util.Stack;

/**
 * @Title: DailyTemperatures_739
 * @Description: https://leetcode-cn.com/problems/daily-temperatures/
 * @Author xiaodong.zou
 * @Date 2020/6/11 9:20
 */
//739. 每日温度
//		根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
//
//		例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
//
//		提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
public class DailyTemperatures_739 {

	public static void main(String[] args) {
		int[] result = dailyTemperatures(new int[]{34,80,80,34,34,80,80,80,80,34});
//		int[] result_1 = dailyTemperatures_1(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
//		int[] result_1 = dailyTemperatures_1(new int[]{34,80,80,34,34,80,80,80,80,34});
		int[] result_1 = dailyTemperatures_2(new int[]{34,80,80,34,34,80,80,80,80,34});
		System.out.println(result);
	}

	/**
	 * 循环查找比当前元素大的元素的位置
	 * @param T
	 * @return
	 */
	public static int[] dailyTemperatures(int[] T) {
		int len = T.length;
		int[] result = new int[len];
		result[len-1] = 0;
		for(int i=0;i<len-1;i++){
			for(int j=i+1;j<len;j++){
				if(T[j]>T[i]){
					result[i] = j-i;
					break;
				}
			}
		}
		return result;
	}

	/**
	 * 动态规划+跳跃查询
	 * 73, 74, 75, 71, 69, 72, 76, 73
	 * @param T
	 * @return
	 */
	public static int[] dailyTemperatures_1(int[] T) {
		int len = T.length;
		int[] result = new int[len];
		//没有比最后一天还高的温度了,设置最后一天为0
		result[len-1] = 0;
		for(int i=len-2;i>=0;i--){
			//如果i+1元素大于i元素,则result[i]为1
			if(T[i]<T[i+1]){
				result[i] = 1;
			}else{
				//如果result[i+1]==0,则没有比i元素大于的元素,则result[i]为0
				if(result[i+1] == 0){
					result[i] = 0;
				}else {
					//如果result[i+1]!=0,循环跳跃查找比i元素大的元素位置
					int step = result[i+1];
					do{
						//如果下一个元素比i元素小而且result[i+1+step] == 0,说明没有比当前元素再大的
						if(T[i+1+step] <= T[i] && result[i+1+step] == 0){
							result[i] = 0;
							break;
						}else if(T[i+1+step] > T[i]){ //如果下一个元素比i元素大,则设置result[i] = 1 + step即可
							result[i] = 1 + step;
							break;
						}else{
							//步长接着跳跃到下一个元素的位置
							step += result[i+1+step];
						}
					}while (i+1+step<len);//循环结束的条件是i+1+step<len
				}
			}
		}
		return result;
	}

	/**
	 * 根据题意，从最后一天推到第一天，这样会简单很多。因为最后一天显然不会再有升高的可能，结果直接为0。
	 * 再看倒数第二天的温度，如果比倒数第一天低，那么答案显然为1，如果比倒数第一天高，又因为倒数第一天
	 * 对应的结果为0，即表示之后不会再升高，所以倒数第二天的结果也应该为0。
	 * 自此我们容易观察出规律，要求出第i天对应的结果，只需要知道第i+1天对应的结果就可以：
	 * - 若T[i] < T[i+1]，那么res[i]=1；
	 * - 若T[i] > T[i+1]
	 *   - res[i+1]=0，那么res[i]=0;
	 *   - res[i+1]!=0，那就比较T[i]和T[i+1+res[i+1]]（即将第i天的温度与比第i+1天大的那天的温度进行比较）
	 */
	public int[] dailyTemperatures_3(int[] T) {
		int[] res = new int[T.length];
		res[T.length - 1] = 0;
		for (int i = T.length - 2; i >= 0; i--) {
			for (int j = i + 1; j < T.length; j += res[j]) {
				if (T[i] < T[j]) {
					res[i] = j - i;
					break;
				} else if (res[j] == 0) {
					res[i] = 0;
					break;
				}
			}
		}
		return res;
	}

	/**
	 * 单调栈
	 * https://leetcode-cn.com/problems/daily-temperatures/solution/leetcode-tu-jie-739mei-ri-wen-du-by-misterbooo/
	 * @param T
	 * @return
	 */
	public static int[] dailyTemperatures_2(int[] T) {
		Stack<Integer> stack = new Stack<>();
		int length = T.length;
		int[] result = new int[length];

		for (int i = 0; i < length; i++) {
			while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
				int pre = stack.pop();
				result[pre] = i - pre;
			}
			stack.add(i);

		}
		return result;
	}

}
