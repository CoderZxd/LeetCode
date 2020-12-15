package com.zxd.test.leetcode;

/**
 * @Description https://leetcode-cn.com/problems/monotone-increasing-digits/
 * @Author zouxiaodong
 * @Date 2020/12/15 8:49
 */
//738. 单调递增的数字
//        给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
//        （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
//
//        示例 1:
//        输入: N = 10
//        输出: 9

//        示例 2:
//        输入: N = 1234
//        输出: 1234

//        示例 3:
//        输入: N = 332
//        输出: 299
//        说明: N 是在 [0, 10^9] 范围内的一个整数。
public class MonotoneIncreasingDigits_738 {

    public static void main(String[] args) {
        MonotoneIncreasingDigits_738 monotoneIncreasingDigits_738 = new MonotoneIncreasingDigits_738();
        System.out.println(monotoneIncreasingDigits_738.monotoneIncreasingDigits(332));
    }

    public int monotoneIncreasingDigits(int N) {
        int i = 1;
        int res = N;
        while(i <= res/10) {
            int n = res / i % 100; // 每次取两个位
            i *= 10;
            if(n/10 > n%10) // 比较的高一位大于底一位
                res = res / i * i - 1; //例如1332 循环第一次变为1330-1=1329 第二次变为1300-1=1299
        }
        return res;
    }
    
    /**
     * @Author zouxiaodong
     * @Description 不要想复杂，思路很简单，向前遍历，前一项大于后一项，前一项就减1，后面所有都变成9
     * @Date 2020/12/15 9:04
     * @Param [N]
     * @return int
     **/
    public int monotoneIncreasingDigits_2(int N) {
        String num=String.valueOf(N);
        char[] arr=num.toCharArray();
        int len=arr.length;
        if(len<2) {
            return N;
        }
        for(int i=len-2;i>=0;i--) {
            if(arr[i]-'0'>arr[i+1]-'0') {
                arr[i]=(char) (arr[i]-'1'+'0');
                for(int j=i+1;j<len;j++) {
                    arr[j]='9';
                }
            }
        }
        return Integer.parseInt(new String(arr));
    }
}
