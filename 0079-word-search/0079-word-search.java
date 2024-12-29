class Solution {
    public boolean exist(char[][] board, String word) {
        // recursive
        // used[i] to record
        // dfs

        int m = board.length;
        int n = board[0].length;
        boolean[][] used = new boolean[m][n];

        // Start backtracking from every cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtracking(board, word, used, 0, i, j, m, n)) {
                    return true; // Return true if the word is found
                }
            }
        }

        return false; // Word not found
    }
    public boolean backtracking(char[][] board, String word, boolean[][] used, int index, int i , int j, int m, int n){
        if(index == word.length()){
            return true;
        } 
         // Check boundaries and conditions
        if (i < 0 || i >= m || j < 0 || j >= n || used[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }
        // Mark the cell as used
        used[i][j] = true;
        // Explore all four directions
        boolean found = backtracking(board, word, used, index + 1, i + 1, j, m, n) ||
                        backtracking(board, word, used, index + 1, i - 1, j, m, n) ||
                        backtracking(board, word, used, index + 1, i, j + 1, m, n) ||
                        backtracking(board, word, used, index + 1, i, j - 1, m, n);
        used[i][j] = false;
        return found;
    }
}