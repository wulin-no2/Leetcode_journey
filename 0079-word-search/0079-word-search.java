class Solution {
    // boolean res = false;
    public boolean exist(char[][] board, String word) {
        // DFS or backtracking
        int m = board.length;
        int n = board[0].length;
        //int len = word.length();
        // DFS for each elements;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(dfs(i, j, 0, board, word)) return true;
            }
        }
        return false;  
    }
    private boolean dfs(int i, int j, int start, char[][] board, String word){
        if(start == word.length()) return true; // handle end case;
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(start)) return false; // handle boundary case;
        char temp = board[i][j];
        board[i][j] = '#'; // record visited to optimize efficiency;
        boolean found = 
            dfs(i, j + 1, start + 1, board, word) ||
            dfs(i + 1, j, start + 1, board, word) ||
            dfs(i, j - 1, start + 1, board, word) ||
            dfs(i - 1, j, start + 1, board, word);
        board[i][j] = temp; // restore the value;
        return found;
    }
}