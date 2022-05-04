package leetcode.editor.cn;

public class P37_SudokuSolver{
    public static void main(String[] args) {
        Solution solution = new P37_SudokuSolver().new Solution();
        // TO TEST
    }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * 思路：
 * 1. for i判断行, for j判断列,递归则从1-9判断合不合理，合理就放进格子再把填完后的board放进递归，
 *      让它自己填，最终一旦填完，整个就会返回true，直接终止即可
 * 2. 但是要是当前格子找不到合适的填，那直接return false
 * 3. 要是遍历完了整个board，意味着每个格子都是isValid，即都能填到数，那就意味着找到答案了，return true
 */
class Solution {
    public void solveSudoku(char[][] board) {
        solveSudokuHelper(board);
    }
    boolean solveSudokuHelper(char[][] board){
        for (int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.') continue;
                for(char k='1';k<='9';k++){
                    // 需要在已经填完当前格之后再往后填，否则if (solveSudokuHelper(board))
                    // 判断的board始终都没填当前格子，每次进更深的递归到当前格子的时候都会再进下去
                    /**
                     * 原代码：
                     * if(isValid(board,k,i,j)){
                     * board[i][j]=k;
                     * }
                     * if (solveSudokuHelper(board))
                     * return true;
                     */
                    if(isValid(board,k,i,j)){
                        board[i][j]=k;
                        if(solveSudokuHelper(board))
                            return true;
                        // 记得回溯,因为k不一定找到答案，k之后的还得判断
                        board[i][j]='.';
                    }
                }
                // 9个数都!isValid的话那就没解了，直接returnfalse
                return false;
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, char val, int row, int col) {
        // 同一行有无重复
        for (int i=0;i<9;i++){
            if(board[row][i]==val)
                return false;
        }

        //同一列
        for(int j=0;j<9;j++){
            if(board[j][col]==val){
                return false;
            }
        }

        // 同一九宫格
        int startRow=(row/3)*3;
        int startCol=(col/3)*3;
        for(int i=startRow;i<startRow+3;i++){
            for (int j=startCol;j<startCol+3;j++){
                if(board[i][j]==val){
                    return false;
                }
            }
        }
        // 全都没return false，那么就合理
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}