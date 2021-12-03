package 初级算法.数组;

import java.util.HashSet;
import java.util.Set;

/**
 * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2f9gg/
 */
public class 有效的数独 {
    public static void main(String[] args) {
        char[][] board =
                {{'8','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};
        boolean res = isValidSudoku(board);
        System.out.println(res);
    }


    /**
     * 利用set集合判断重复性
     */
    public static boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>();
        // 判断行数字是否重复
        for(int i=0; i<9; i++){
            set.clear();
            for(int j=0; j<9; j++){
                if(board[i][j] != '.'){
                    if(!set.add(board[i][j])){
                        // 非数独
                        return false;
                    }
                }
            }
        }
        // 判断列数字是否重复
        for(int i=0; i<9; i++){
            set.clear();
            for(int j=0; j<9; j++){
                if(board[j][i] != '.'){
                    if(!set.add(board[j][i])){
                        // 非数独
                        return false;
                    }
                }
            }
        }
        // 判断九宫格是否重复
        int h = 0;
        int l = 0;
        for(int hh=0; hh<3; hh++){
            h = hh*3;   // 行起始位置 0 3 6
            for(int ll=0; ll<3; ll++){
                l = ll*3;   // 列起始位置 0 3 6
                set.clear();
                for(int i=h; i<h+3; i++){ // 行
                    for(int j=l; j<l+3; j++){ // 列
                        if(board[i][j] != '.'){
                            if(!set.add(board[i][j])){
                                // 非数独
                                return false;
                            }
                        }
                    }
                }
            }
        }

        return true;
    }
}
