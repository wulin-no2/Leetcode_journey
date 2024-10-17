class Solution {
    public boolean isValidSudoku(char[][] board) {
        return isValidRow(board) && isValidColumn(board) && isValidCube(board);
        
    }
    public boolean isValidColumn(char[][] board){
        int length = board.length;
        for(int j = 0; j < length; j++){
            // check valid column;
            HashSet<Character> set = new  HashSet<>();
            for(int i = 0; i < length ; i++){
                if(board[i][j]!='.' && set.contains(board[i][j])) return false;
                set.add(board[i][j]); 
            }
        }
        return true;
    }
    public boolean isValidRow(char[][] board){
        int length = board.length;
        for(int i = 0; i < length; i++){
            // check valid row;
            HashSet<Character> set = new  HashSet<>();
            for(int j = 0; j < length ; j++){
                if(board[i][j]!='.' && set.contains(board[i][j])) return false;
                set.add(board[i][j]); 
            }
        }
        return true;
    }
    public boolean isValidCube(char[][] board){
        int length = board.length;
        for(int i = 0; i < length; i+=3){
            for(int j = 0; j < length; j+=3){
                // check valid cube;
                HashSet<Character> set = new  HashSet<>();
                for(int m = i;m <= i+2; m++){
                    for(int n = j;n <= j+2; n++){
                         if(board[m][n]!='.' && set.contains(board[m][n])) return false;
                         set.add(board[m][n]); 
                    }
                }
            }
        }
        return true;
        
        
    }
}