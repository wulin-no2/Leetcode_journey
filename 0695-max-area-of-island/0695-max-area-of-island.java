class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        // dfs
        if(grid == null || grid.length == 0) return 0;
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for(int i = 0 ; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j]==1){
                    int num = dfs(grid, i, j);
                    count = Math.max(count, num);
                }

            }
        } 
        return count;
    }
    private int dfs(int[][] grid, int i , int j){
        // base case
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j]==0) return 0;
        grid[i][j] = 0;
        return dfs(grid, i + 1, j) + dfs(grid, i - 1, j) + dfs(grid, i, j + 1) + dfs(grid, i, j - 1) + 1;
    }
}