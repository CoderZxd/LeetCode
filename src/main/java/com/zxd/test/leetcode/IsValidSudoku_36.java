package com.zxd.test.leetcode;

import java.util.*;

/**
 * @Author zouxiaodong
 * @Description https://leetcode-cn.com/problems/valid-sudoku/submissions/
 * @Date 2021/09/17 11:23
 **/
//36. 有效的数独
//        请你判断一个 9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
//
//        数字 1-9 在每一行只能出现一次。
//        数字 1-9 在每一列只能出现一次。
//        数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
//        数独部分空格内已填入了数字，空白格用 '.' 表示。
//
//        注意：
//
//        一个有效的数独（部分已被填充）不一定是可解的。
//        只需要根据以上规则，验证已经填入的数字是否有效即可。
//
//
//        示例 1：
//
//
//        输入：board =
//        [["5','3','.','.','7','.','.','.','."]
//        ,["6','.','.','1','9','5','.','.','."]
//        ,[".','9','8','.','.','.','.','6','."]
//        ,["8','.','.','.','6','.','.','.','3"]
//        ,["4','.','.','8','.','3','.','.','1"]
//        ,["7','.','.','.','2','.','.','.','6"]
//        ,[".','6','.','.','.','.','2','8','."]
//        ,[".','.','.','4','1','9','.','.','5"]
//        ,[".','.','.','.','8','.','.','7','9"]]
//        输出：true
//        示例 2：
//
//        输入：board =
//        [["8','3','.','.','7','.','.','.','."]
//        ,["6','.','.','1','9','5','.','.','."]
//        ,[".','9','8','.','.','.','.','6','."]
//        ,["8','.','.','.','6','.','.','.','3"]
//        ,["4','.','.','8','.','3','.','.','1"]
//        ,["7','.','.','.','2','.','.','.','6"]
//        ,[".','6','.','.','.','.','2','8','."]
//        ,[".','.','.','4','1','9','.','.','5"]
//        ,[".','.','.','.','8','.','.','7','9"]]
//        输出：false
//        解释：除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
//
//
//        提示：
//
//        board.length == 9
//        board[i].length == 9
//        board[i][j] 是一位数字或者 '.'
public class IsValidSudoku_36 {
    public static void main(String[] args){
//        char[][] board = new char[][]{{'5','3','.','.','7','.','.','.','.'},
//                                      {'6','2','.','1','9','5','.','.','.'},
//                                      {'.','9','8','.','.','.','.','6','.'},
//                                      {'8','.','.','.','6','.','.','.','3'},
//                                      {'4','.','.','8','.','3','.','.','1'},
//                                      {'7','.','.','.','2','.','.','.','6'},
//                                      {'.','6','.','.','.','.','2','8','.'},
//                                      {'.','.','.','4','1','9','.','.','5'},
//                                      {'.','.','.','.','8','.','.','7','9'}};
//        char[][] board = new char[][]
//                {{'8','3','.','.','7','.','.','.','.'}
//                ,{'6','.','.','1','9','5','.','.','.'}
//                ,{'.','9','8','.','.','.','.','6','.'}
//                ,{'8','.','.','.','6','.','.','.','3'}
//                ,{'4','.','.','8','.','3','.','.','1'}
//                ,{'7','.','.','.','2','.','.','.','6'}
//                ,{'.','6','.','.','.','.','2','8','.'}
//                ,{'.','.','.','4','1','9','.','.','5'}
//                ,{'.','.','.','.','8','.','.','7','9'}};
        char[][] board = new char[][]
                {{'.','.','4','.','.','.','6','3','.'},
                 {'.','.','.','.','.','.','.','.','.'},
                 {'5','.','.','.','.','.','.','9','.'},
                 {'.','.','.','5','6','.','.','.','.'},
                 {'4','.','3','.','.','.','.','.','1'},
                 {'.','.','.','7','.','.','.','.','.'},
                 {'.','.','.','5','.','.','.','.','.'},
                 {'.','.','.','.','.','.','.','.','.'},
                 {'.','.','.','.','.','.','.','.','.'}};
        IsValidSudoku_36 isValidSudoku_36 = new IsValidSudoku_36();
        System.out.println(isValidSudoku_36.isValidSudoku_1(board));
    }
    public boolean isValidSudoku_1(char[][] board) {
        int[] nums = new int[10];
        //横向
        for(int i=0;i<9;i++){
            Arrays.fill(nums,0);
            for(int j=0;j<9;j++){
                if(board[i][j] != '.'){
                    if(nums[board[i][j]-'0'] != 0){
                        return false;
                    }else {
                        nums[board[i][j]-'0'] = 1;
                    }
                }
            }
        }
        //纵向
        for(int i=0;i<9;i++){
            Arrays.fill(nums,0);
            for(int j=0;j<9;j++){
                if(board[j][i] != '.'){
                    if(nums[board[j][i]-'0'] != 0){
                        return false;
                    }else {
                        nums[board[j][i]-'0'] = 1;
                    }
                }
            }
        }
        //3*3 9宫格
        for(int i=0;i<9;i=i+3){
            for(int j=0;j<9;j=j+3){
                Arrays.fill(nums,0);
                for(int x=i;x<i+3;x++){
                    for(int y=j;y<j+3;y++){
                        if(board[x][y] != '.'){
                            if(nums[board[x][y]-'0'] != 0){
                                return false;
                            }else {
                                nums[board[x][y]-'0'] = 1;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
