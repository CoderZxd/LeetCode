package com.zxd.test.leetcode;

import java.util.*;

/**
 * @Project war-fx-glt2stage-demo
 * @Package com.zxd.test.leetcode
 * @Author：zouxiaodong
 * @Description:
 * @Date:Created in 12:04 2018/8/31.
 */
public class LeetCodeArrayTest {
    public static void main(String[] args){
        char[][] board = new char[][]{{'5','3','.','.','7','.','.','.','.'},
                                      {'6','2','.','1','9','5','.','.','.'},
                                      {'.','9','8','.','.','.','.','6','.'},
                                      {'8','.','.','.','6','.','.','.','3'},
                                      {'4','.','.','8','.','3','.','.','1'},
                                      {'7','.','.','.','2','.','.','.','6'},
                                      {'.','6','.','.','.','.','2','8','.'},
                                      {'.','.','.','4','1','9','.','.','5'},
                                      {'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(board));
        int[][] matrix = new int[][]{{1,2,3},
                                     {4,5,6},
                                     {7,8,9}};
        rotate(matrix);
    }


    /**
     * 从排序数组中删除重复项
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int j = 0;
        if(nums.length == 0 || null == nums){
            return 0;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i] != nums[j]){
                j++;
                nums[j]=nums[i];
            }
        }
        return j+1;
    }
    /**
     * 旋转数组
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        for(int i =0;i<k;i++){
            int temp = nums[length-1];
            for(int j=length-1;j>0;j--){
                nums[j] = nums[j-1];
            }
            nums[0] = temp;
        }
    }
    /**
     * 存在重复
     * @param nums
     * @return
     */
    public static  boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }

    /**
     * 只出现一次的数字
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(i!=j && nums[i] == nums[j]){
                    break;
                }
                if(j == nums.length-1){
                    System.out.println(nums[i]);
                    return nums[i];
                }
            }
        }
        return -1;
    }

    /**
     * 两个数组的交集 II
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> ret = new ArrayList<Integer>(10);
        Map<Integer,Integer> num1Map = new HashMap<Integer,Integer>(16);
        for(int i=0;i<nums1.length;i++){
            if(num1Map.containsKey(nums1[i])){
                num1Map.put(nums1[i],num1Map.get(nums1[i])+1);
            }else{
                num1Map.put(nums1[i],1);
            }
        }
        for(int j=0;j<nums2.length;j++){
            if(num1Map.containsKey(nums2[j]) && num1Map.get(nums2[j])>=1){
                ret.add(nums2[j]);
                num1Map.put(nums2[j],num1Map.get(nums2[j])-1);
            }
        }
        int[] result = new int[ret.size()];
        for(int i=0;i<ret.size();i++){
            result[i]=ret.get(i);
        }
        return result;
    }

    /**
     * 加一
     * 输入: [4,3,2,1]
     * 输出: [4,3,2,2]
     * 解释: 输入数组表示数字 4321。
     * 此种方式存在整数越界的问题，不支持处理大数组
     * @param digits
     * @return
     */
//    public static int[] plusOne(int[] digits) {
//        int length = digits.length;
//        long result = 0L;
//        for(int i=0;i<length;i++){
//            result += digits[i]*Math.pow(10,length-1-i);
//        }
//        result++;
//        String resultString = String.valueOf(result);
//        String[] array = resultString.split("");
//        int[] resultArray = new int[array.length];
//        for(int i=0;i<array.length;i++){
//            resultArray[i] = Integer.parseInt(array[i]);
//        }
//        return resultArray;
//    }

    /**
     * 加一
     * 输入: [9,9,9,9,9,9,9,9,9,9]
     * 输出: [1,0,0,0,0,0,0,0,0,0,0]
     * 解释: 输入数组表示数字 999999999。
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        int length = digits.length;
        digits[length-1] +=1;
        for(int i=length-1;i>=0;i--){
            if(10 == digits[i] && i != 0){
                digits[i] = 0;
                digits[i-1] +=1;
            }else{
                break;
            }
        }
        if(digits[0] == 10){
            int[] result = new int[length+1];
            result[0] = 1;
            result[1] = 0;
            for(int i=1;i<length;i++){
                result[i+1] = digits[i];
            }
           return  result;
        }
        return digits;
    }

    /**
     * 移动零
     *
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * 示例:
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        int length = nums.length;
        int temp;
        for(int j=0;j<length-1;j++){
            for(int i=0;i<length-1-j;i++){
                if(nums[i]==0 && nums[i+1] != 0){
                    temp = nums[i+1];
                    nums[i+1] = nums[i];
                    nums[i] = temp;
                }
            }
        }
    }

    /**
     * 两数之和
     *
     * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
     * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
     *
     * 给定 nums = [2, 7, 11, 15], target = 9

     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        boolean isFind = false;
        List<Integer> re = new ArrayList<Integer>(10);
        int length = nums.length;
        for(int i=0;i<length-1&&!isFind;i++){
            int r = target - nums[i];
            for(int j=i+1;j<length;j++){
                if(nums[j]==r){
                    re.add(i);
                    re.add(j);
                    isFind = true;
                    break;
                }
            }
        }
        int[] result = new int[re.size()];
        for(int i=0;i<re.size();i++){
            result[i]=re.get(i);
        }
        return result;
    }

    /**
     * 有效的数独
     * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。

     * 数字 1-9 在每一行只能出现一次。
     * 数字 1-9 在每一列只能出现一次。
     * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
     *
     * 输入:
     * [ 0   1   2   3   4   5   6   7   8
     *0["5","3",".",".","7",".",".",".","."],
     *1["6",".",".","1","9","5",".",".","."],
     *2[".","9","8",".",".",".",".","6","."],
     *3["8",".",".",".","6",".",".",".","3"],
     *4["4",".",".","8",".","3",".",".","1"],
     *5["7",".",".",".","2",".",".",".","6"],
     *6[".","6",".",".",".",".","2","8","."],
     *7[".",".",".","4","1","9",".",".","5"],
     *8[".",".",".",".","8",".",".","7","9"]
     * ]
     * 输出: true
     * @param board
     * @return
     */
    public static boolean isValidSudoku(char[][] board) {
        int x = board.length;
        int y = board[0].length;
        boolean result = true;
        for(int i=0;i<x && result;i++){
            Set<Character> temp = new HashSet<Character>(16);
            for(int j=0;j<y;j++){
                if(board[i][j] != '.' && !temp.add(board[i][j])){
                    result = false;
                    break;
                }

            }
        }
        for(int j=0;j<y && result;j++){
            Set<Character> temp = new HashSet<Character>(16);
            for(int i=0;i<x;i++){
                if(board[i][j] != '.' && !temp.add(board[i][j])){
                    result = false;
                    break;
                }
            }
        }
        for(int i=0;i<9 && result;i=i+3){
            for(int j=0;j<9 && result;j=j+3){
                Set<Character> temp = new HashSet<Character>(16);
                for(int a=i;a<i+3 && result;a++){
                    for(int b=j;b<j+3 && result;b++){
                        if(board[a][b] != '.' && !temp.add(board[a][b])){
                            result = false;
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }

//    旋转图像
//    给定一个 n × n 的二维矩阵表示一个图像。
//
//    将图像顺时针旋转 90 度。
//
//    说明：
//
//    你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
//
//    示例 1:
//
//    给定 matrix =
//       [
//        [1,2,3],
//        [4,5,6],
//        [7,8,9]
//        ],
//    调换对角
//       [
//        [9,6,3],
//        [8,5,2],
//        [7,4,1]
//        ],
//
//    原地旋转输入矩阵，使其变为:
//            [
//            [7,4,1],
//            [8,5,2],
//            [9,6,3]
//            ]
    public static void rotate(int[][] matrix) {
        int length = matrix.length;
        // 调换对角元素
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[length - j - 1][length - i - 1];
                matrix[length - j - 1][length - i - 1] = tmp;
            }
        }
        // 调换列元素
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length / 2; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[length - j - 1][i];
                matrix[length - j - 1][i] = tmp;
            }
        }
    }
}
