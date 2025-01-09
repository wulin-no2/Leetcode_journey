class Solution {
    public boolean isValidSudoku(char[][] board) {
        // traverse the board, if the char is not '.', record its existence.
        // for each number, check if it already exists in its row, its column, its cube;
        boolean[][] rows = new boolean[9][9]; // if row i exist num j
        boolean[][] cols = new boolean[9][9]; // if col i exist num j       
        boolean[][] cubes = new boolean[9][9]; // if cube i exist num j 
        for(int i = 0; i < 9 ;i++){
            for(int j = 0; j < 9 ; j++){
                if(board[i][j] != '.'){
                    int num = board[i][j]-'1';
                    // check row
                    if(rows[i][num]) return false;
                    else rows[i][num] = true;

                    // check col
                    if(cols[j][num]) return false;
                    else cols[j][num] = true;

                    // check cube
                    int cube = (i/3) * 3+ (j/3);
                    if(cubes[cube][num]) return false;
                    else cubes[cube][num] = true;
                }
            }
        }
        return true;       
    }
}