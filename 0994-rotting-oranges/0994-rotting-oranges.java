class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return -1;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 2) dfs(grid, i, j, 2);
            }
        }
        int min = 2;
        for(int[] row : grid){
            for(int cell: row){
                if(cell == 1) return -1;
                min = Math.max(min, cell);
            }
        }
        return min - 2;
    }
        
        private void dfs(int[][] grid, int i, int j, int min){
            if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0
              || (grid[i][j] > 1 && grid[i][j] < min)) return;
            grid[i][j] = min;
            dfs(grid, i - 1, j , min + 1);
            dfs(grid, i + 1, j , min + 1);
            dfs(grid, i, j - 1, min + 1);
            dfs(grid, i, j + 1, min + 1);
        }
}
        
        
        
        
        
        
        
        
        // we can do it in BFS or DFS;
        // similar to Flood Fill;
        // DFS first;
        /*
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        if(m == n == 1) {
            if(grid[m][n] == 2) return 0;
            else return -1;
        }
        // DFS:
        Queue<Pair> queue = new LinkedList<>();
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(border(i,j)) queue.offer(new Pair(i, j));
            }
        }
        while()
        */
                
        // BFS; first offer all the borders;
        
        /*
        Queue<Pair> queue = new LinkedList<>();
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(border(i,j)) queue.offer(new Pair(i, j));
            }
        }
        // BFS;
        while(! queue.isEmpty()){
            Pair temp = queue.poll();
            if(valid(temp[0],temp[1])){
                grid[temp[0],temp[1]] = 2;
                if(boarder(temp[0],temp[1])){
                    queue.offer(new Pair(temp[0],temp[1]));
                    }
                }
            if(valid(temp[0],temp[1])){
                grid[temp[0],temp[1]] = 2;
                if(boarder(temp[0],temp[1])){
                    queue.offer(new Pair(temp[0],temp[1]));
                    }
                }
            
        }
        return -1; 
        */
    
    /*
    private boolean border(int r, int c){
        // what is border? there exists an elements around grid[r][c] == 1;
        //if(grid[r][c] == 0 || grid[r][c] == 1) return false;
        if(valid(r, c - 1) || valid(r, c + 1) || valid(r - 1, c) || valid(r + 1, c)) return true;
        return false; 
    }
    private boolean valid(int r, int c){
        if(r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1) return true;
        return false;
    }
    */
    
