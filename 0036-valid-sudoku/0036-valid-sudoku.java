class Solution {
    public boolean isValidSudoku(char[][] board) {
        // 3 passes. check row, check column, check box
        boolean[][] rows = new boolean[9][9]; // if row i has num j
        boolean[][] cols = new boolean[9][9]; // if col i has num j
        boolean[][] boxes = new boolean[9][9]; // if box i has num j
        for(int i = 0 ; i < 9 ; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    int num = board[i][j] - '1'; // num is in 0~8
                    // check row
                    if(rows[i][num]) return false;
                    rows[i][num] = true;

                    // check col
                    if(cols[j][num]) return false;
                    cols[j][num] = true;

                    // check box
                    int box = (i / 3) * 3 + ( j / 3);
                    if(boxes[box][num]) return false;
                    boxes[box][num] = true;
                }
            }
        }  
        return true;              
    }
}