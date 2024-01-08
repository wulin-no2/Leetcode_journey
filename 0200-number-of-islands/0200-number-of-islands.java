class Solution {
    // approach 1:
    // 1) traverse each pixel of the grid;
    // 2) for each pixid, if it's '1', use floodFill to mark the island then count++;
    // 3) we need a helper method to assist.
    
    private int n;
    private int m;
    public int numIslands(char[][] grid) {
        int count = 0;
        n = grid.length;
        if (n == 0) return 0;
        m = grid[0].length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++)
                if (grid[i][j] == '1') {
                    DFSMarking(grid, i, j);
                    count++;
                }
        }    
        return count;
    }
    private void DFSMarking(char[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= n || y >= m || grid[x][y] != '1') return;
        grid[x][y] = '2';
        DFSMarking(grid, x + 1, y);
        DFSMarking(grid, x - 1, y);
        DFSMarking(grid, x, y + 1);
        DFSMarking(grid, x, y - 1);
    }
}