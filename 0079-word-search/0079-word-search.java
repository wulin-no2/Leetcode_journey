class Solution {
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        // dfs for every space in the board
        m = board.length;
        n = board[0].length;
        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n ; j++){
                if(board[i][j]!='#' && dfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, int i, int j, int index){
        // base case
        if(i < 0 || j < 0 || i >= m || j >= n || index >= word.length() || board[i][j] != word.charAt(index)) return false;
        if(index == word.length() - 1 && board[i][j] == word.charAt(index)) return true;
        // if this space is valid, put a flag here so we know we've visited it;
        board[i][j] = '#';
        index++;
        boolean res = dfs(board, word, i + 1, j, index) 
        || dfs(board, word, i - 1, j, index) 
        || dfs(board, word, i , j + 1, index) 
        || dfs(board, word, i , j - 1, index);
        index--;
        board[i][j] = word.charAt(index);
        return res;
    }
}