package com.zxd.test.leetcode;

/**
 * @Description https://leetcode-cn.com/problems/rectangle-area/
 * @Author zouxiaodong
 * @Date 2021/09/30 9:08
 */
//223. 矩形面积
//        给你 二维 平面上两个 由直线构成的 矩形，请你计算并返回两个矩形覆盖的总面积。
//
//        每个矩形由其 左下 顶点和 右上 顶点坐标表示：
//
//        第一个矩形由其左下顶点 (ax1, ay1) 和右上顶点 (ax2, ay2) 定义。
//        第二个矩形由其左下顶点 (bx1, by1) 和右上顶点 (bx2, by2) 定义。
//
//
//        示例 1：
//
//        Rectangle Area
//        输入：ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2
//        输出：45
//        示例 2：
//
//        输入：ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = -2, by1 = -2, bx2 = 2, by2 = 2
//        输出：16
//
//
//        提示：
//
//        -10^4 <= ax1, ay1, ax2, ay2, bx1, by1, bx2, by2 <= 10^4
public class ComputeArea_223 {

    public static void main(String[] args) {
        ComputeArea_223 computeArea_223 = new ComputeArea_223();
        System.out.println(computeArea_223.computeArea(-3,0,3,4,0,-1,9,2));
        System.out.println(computeArea_223.computeArea(-2,-2,2,2,-2,-2,2,2));
    }

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int result =  (ax2-ax1)*(ay2-ay1) + (bx2-bx1)*(by2-by1);
        int x3 = Math.min(ax2,bx2);
        int y3 = Math.min(ay2,by2);
        int x4 = Math.max(ax1,bx1);
        int y4 = Math.max(ay1,by1);
        if(x3>=ax1 && x3<=ax2 && x3 >= bx1 && x3 <= bx2 &&
                y3 >=ay1 && y3 <=ay2 && y3>=by1 && y3<=by2 &&
                x4>=ax1 && x4<=ax2 && x4>=bx1 && x4<=bx2 &&
                y4>=ay1 && y4<=ay2 && y4>=by1 && y4<=by2){
            result -=(x3-x4)*(y3-y4);
        }
        return result;
    }
}
