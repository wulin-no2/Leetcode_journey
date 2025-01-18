class Solution {
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        // dfs
        // use visited[] to record if we've visited the space
        m = board.length;
        n = board[0].length;

        int[][] visited = new int[m][n];
        for(int i = 0; i < m ; i++){
            for(int j = 0 ; j < n; j++){
                if(board[i][j] == word.charAt(0) && dfs(board, word, visited, i, j, 0)) return true;
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, int[][] visited, int i, int j, int index){
        // base case
        if(index == word.length()) return true;
        if( i < 0 || j < 0 || i >=m || j >=n || visited[i][j] == 1 || index > word.length() || word.charAt(index) != board[i][j]) return false;
        index++;
        visited[i][j] = 1;
        boolean nextValid = dfs(board, word, visited, i-1 , j , index)
        || dfs(board, word, visited, i + 1, j, index)
        || dfs(board, word, visited, i , j + 1 , index)
        || dfs(board, word, visited, i , j - 1 , index);
        index--;
        visited[i][j] = 0;
        return nextValid;
    }
}