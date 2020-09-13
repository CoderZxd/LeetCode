package com.zxd.test.leetcode;

/**
 * @ClassName Exist_79
 * @Description https://leetcode-cn.com/problems/word-search/
 * @Author xiaodong.zou
 * @Date 2020/9/13 9:13
 * @Version 1.0
 */
//79. 单词搜索
//        给定一个二维网格和一个单词，找出该单词是否存在于网格中。
//        单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
//
//        示例:
//
//        board =
//        [
//        ['A','B','C','E'],
//        ['S','F','C','S'],
//        ['A','D','E','E']
//        ]
//
//        给定 word = "ABCCED", 返回 true
//        给定 word = "SEE", 返回 true
//        给定 word = "ABCB", 返回 false
//
//        提示：
//        board 和 word 中只包含大写和小写英文字母。
//        1 <= board.length <= 200
//        1 <= board[i].length <= 200
//        1 <= word.length <= 10^3
public class Exist_79 {

    public static void main(String[] args) {
        Exist_79 exist_79 = new Exist_79();
        char[] c1 = new char[]{'A','B','C','E'};
//        char[] c1 = new char[]{'a','b'};

        char[] c2 = new char[]{'S','F','C','S'};
        char[] c3 = new char[]{'A','D','E','E'};
        char[][] board = new char[][]{c1,c2,c3};
//        char[][] board = new char[][]{c1};
        System.out.println(exist_79.exist(board,"ABCCED"));
        System.out.println(exist_79.exist(board,"SEE"));
        System.out.println(exist_79.exist(board,"ABCB"));
        System.out.println(exist_79.exist(board,"A"));
        System.out.println(exist_79.exist(board,"D"));
//        System.out.println(exist_79.exist(board,"ba"));
    }

    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] path = new boolean[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                path =  new boolean[row][col];
                StringBuilder sb = new StringBuilder(String.valueOf(board[i][j]));
                if(dfs(path,sb,board,word,i,j)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(boolean[][] path,StringBuilder str,char[][] board, String word,int i,int j){
        path[i][j]=true;
        if(str.toString().equals(word)){
            return true;
        }
        if(word.startsWith(str.toString())){
            int row = board.length;
            int col = board[0].length;
            if(i+1<row && !path[i+1][j]){
                path[i+1][j] = true;
                str.append(board[i+1][j]);
                if(dfs(path,str,board,word,i+1,j)){
                    return true;
                }
                str.deleteCharAt(str.length()-1);
                path[i+1][j] = false;
            }
            if(i-1>=0 && !path[i-1][j]){
                path[i-1][j] = true;
                str.append(board[i-1][j]);
                if(dfs(path,str,board,word,i-1,j)){
                    return true;
                };
                str.deleteCharAt(str.length()-1);
                path[i-1][j] = false;
            }
            if(j+1<col && !path[i][j+1]){
                path[i][j+1] = true;
                str.append(board[i][j+1]);
                if(dfs(path,str,board,word,i,j+1)){
                    return true;
                }
                str.deleteCharAt(str.length()-1);
                path[i][j+1] = false;
            }
            if(j-1>=0 && !path[i][j-1]){
                path[i][j-1] = true;
                str.append(board[i][j-1]);
                if(dfs(path,str,board,word,i,j-1)){
                    return true;
                }
                str.deleteCharAt(str.length()-1);
                path[i][j-1] = false;
            }
        }
        return false;
    }
}
