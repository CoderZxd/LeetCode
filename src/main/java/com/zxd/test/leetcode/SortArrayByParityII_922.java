package com.zxd.test.leetcode;

/**
 * @Description https://leetcode-cn.com/problems/sort-array-by-parity-ii/
 * @Author zouxiaodong
 * @Date 2020/11/12 11:05
 */
//922. 按奇偶排序数组 II
//        给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
//
//        对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
//
//        你可以返回任何满足上述条件的数组作为答案。
//
//
//
//        示例：
//
//        输入：[4,2,5,7]
//        输出：[4,5,2,7]
//        解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
//
//
//        提示：
//
//        2 <= A.length <= 20000
//        A.length % 2 == 0
//        0 <= A[i] <= 1000
public class SortArrayByParityII_922 {

    public static void main(String[] args) {
        SortArrayByParityII_922 sortArrayByParityII_922 = new SortArrayByParityII_922();
//        int[] result = sortArrayByParityII_922.sortArrayByParityII(new int[]{4,2,5,7});
//        int[] result = sortArrayByParityII_922.sortArrayByParityII(new int[]{1,2,3,4,5,6});
        int[] result = sortArrayByParityII_922.sortArrayByParityII(new int[]{2,3,1,1,4,0,0,4,3,3});
        System.out.println(result);
    }

    public int[] sortArrayByParityII(int[] A) {
        int len = A.length;
        int[] result = new int[len];
        int i=0,j=1;
        for(int ele:A){
            if(ele%2==0){
                result[i]=ele;
                i+=2;
                continue;
            }else{
                result[j]=ele;
                j+=2;
                continue;
            }
        }
        return result;
    }

    /**
     * @Author zouxiaodong
     * @Description 双指针
     * @Date 2020/11/12 13:36
     * @Param [A]
     * @return int[]
     **/
    public int[] sortArrayByParityII_1(int[] A) {
        int n = A.length;
        int j = 1;
        for (int i = 0; i < n; i += 2) {
            if (A[i] % 2 == 1) {
                while (A[j] % 2 == 1) {
                    j += 2;
                }
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        return A;
    }
}
