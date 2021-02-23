package com.zxd.test.leetcode;

/**
 * @Description https://leetcode-cn.com/problems/grumpy-bookstore-owner/
 * @Author zouxiaodong
 * @Date 2021/02/23 9:36
 */
//1052. 爱生气的书店老板
//        今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分钟结束后离开。
//        在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。
//        书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。
//        请你返回这一天营业下来，最多有多少客户能够感到满意的数量。
//
//        示例：
//        输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
//        输出：16
//        解释：
//        书店老板在最后 3 分钟保持冷静。
//        感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
//
//        提示：
//        1 <= X <= customers.length == grumpy.length <= 20000
//        0 <= customers[i] <= 1000
//        0 <= grumpy[i] <= 1
public class MaxSatisfied_1052 {

    public static void main(String[] args) {
        MaxSatisfied_1052 maxSatisfied_1052 = new MaxSatisfied_1052();
        System.out.println(maxSatisfied_1052.maxSatisfied(new int[]{1,0,1,2,1,1,7,5},new int[]{0,1,0,1,0,1,0,1},3));
    }

    /**
     * @Author zouxiaodong
     * @Description
     * @Date 2021/02/23 10:45
     * @Param [customers, grumpy, X]
     * @return int
     **/
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int result = 0;
        int len = customers.length;
        //先将不生气时顾客满意度累加，然后将不生气时顾客清零(也可不清零，后面计算时*grumpy[i]即可，但是麻烦)
        for(int i=0;i<len;i++){
            if(grumpy[i] == 0){
                result+=customers[i];
                //清零不生气时顾客
                customers[i]=0;
            }
        }
        //累加前X个顾客满意度
        int increase = 0;
        for(int i=0;i<X;i++){
            increase +=customers[i];
        }
        int maxIncrease = increase;
        //从第X个计算最大顾客满意度，取最大值+result即为结果
        for(int i=X;i<len;i++){
            increase = increase - customers[i-X]+customers[i];
            maxIncrease = Math.max(increase,maxIncrease);
        }
        return result+maxIncrease;
    }
}
