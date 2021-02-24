package com.zxd.test.leetcode;

/**
 * @Description https://leetcode-cn.com/problems/flipping-an-image/
 * @Author zouxiaodong
 * @Date 2021/02/24 13:38
 */
//832. 翻转图像
//        给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
//        水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
//        反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
//
//        示例 1：
//        输入：[[1,1,0],
//              [1,0,1],
//              [0,0,0]]
//        输出：[[1,0,0],
//              [0,1,0],
//              [1,1,1]]
//        解释：首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
//        然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]

//        示例 2：
//        输入：[[1,1,0,0],
//              [1,0,0,1],
//              [0,1,1,1],
//              [1,0,1,0]]
//        输出：[[1,1,0,0],
//              [0,1,1,0],
//              [0,0,0,1],
//              [1,0,1,0]]
//        解释：首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
//        然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
//
//        提示：
//        1 <= A.length = A[0].length <= 20
//        0 <= A[i][j] <= 1
public class FlipAndInvertImage_832 {

    public static void main(String[] args) {
        FlipAndInvertImage_832 flipAndInvertImage_832 = new FlipAndInvertImage_832();
        int[][] A = new int[4][4];
        A[0] = new int[]{1,1,0,0};
        A[1] = new int[]{1,0,0,1};
        A[2] = new int[]{0,1,1,1};
        A[3] = new int[]{1,0,1,0};
        flipAndInvertImage_832.flipAndInvertImage(A);
        System.out.println(A);
    }

    public int[][] flipAndInvertImage(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        for(int i=0;i<row;i++){
            for(int l=0,r=col-1;l<=r;l++,r--){
                int value = A[i][l];
                A[i][l] = A[i][r]^1;
                A[i][r] = value^1;
            }
        }
        return A;
    }
}
