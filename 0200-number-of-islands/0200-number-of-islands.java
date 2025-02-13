class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        // dfs
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int i, int j){
        // check out of bounds or water cell
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j]=='0') return;
        grid[i][j] = '0'; // mark as visited

        // 4 directions
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}