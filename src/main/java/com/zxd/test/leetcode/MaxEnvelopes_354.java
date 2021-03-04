package com.zxd.test.leetcode;

import java.util.Arrays;

/**
 * @Description https://leetcode-cn.com/problems/russian-doll-envelopes/
 * @Author zouxiaodong
 * @Date 2021/03/04 8:56
 */
//354. 俄罗斯套娃信封问题
//        给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
//        请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
//
//        说明:
//        不允许旋转信封。
//
//        示例:
//        输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
//        输出: 3
//        解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
public class MaxEnvelopes_354 {

    public static void main(String[] args) {
        MaxEnvelopes_354 maxEnvelopes_354 = new MaxEnvelopes_354();
        int[][] envelopes = new int[4][2];
        envelopes[0] = new int[]{5,4};
        envelopes[1] = new int[]{6,4};
        envelopes[2] = new int[]{6,7};
        envelopes[3] = new int[]{2,3};
        maxEnvelopes_354.maxEnvelopes(envelopes);
    }

    public int maxEnvelopes(int[][] envelopes) {
        int row = envelopes.length;
        if(row == 0){
            return row;
        }
        Arrays.sort(envelopes,(o1,o2)-> o1[0]==o2[0]?o2[1]-o1[1]:o1[0]-o2[0]);
        int[] f = new int[row];
        Arrays.fill(f, 1);
        int ans = 1;
        for (int i = 1; i < row; ++i) {
            for (int j = 0; j < i; ++j) {
                if (envelopes[j][1] < envelopes[i][1]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }
}
