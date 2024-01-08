class Solution {
    // approach 1: DFS
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
    
    /* approach 2: BFS
    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        
        int m = grid.length, n = grid[0].length;
        
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    bfs(grid, queue, visited);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    int[][] dirs = {{0,1}, {1,0}, {0, -1}, {-1, 0}};
    private void bfs(char[][] grid, Queue<int[]> queue, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;
        
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] dir : dirs) {
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];
                
                if (x < 0 || x >= m || y < 0 || y >=n || visited[x][y] || grid[x][y] == '0') 
                    continue;
                
                visited[x][y] = true;
                queue.offer(new int[]{x, y});
            }
        }
    }
    */
}