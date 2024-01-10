class Solution {
    
    public int[][] updateMatrix(int[][] mat) {
        /* first time. 2024.1.10. 17:48. can't do it
        // dynamic programming
        // 1) if mat[i][j] == 0, return 0
        // 2) if mat[i][j] == 1:
        //  2.1) if 4 pixel's around it,min has a 0, return 1;
        //  2.2) if not, return 1 + min;
        // 3) for all the 2:
        // ... keep update, until all the pixel has a result; it's BFS
        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];
        // we should use hashMap to store upToNow.
        HashMap<Integer, Integer> upToNow = new HashMap<>;
        // traverse 1 time;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(mat[i][j] == 0) res[i][j] = 0; // upToNow[i][j] = 0;
                else upToNow[i][j] = 1;
            }
        }
        // traverse 2 time;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(upToNow[i][j] == 1) upToNow[i][j] = Math.min(upToNow[i][j], 1 + [][] ); // upToNow[i][j] = 0;
                else upToNow[i][j] = 1;
            }
        }
        while{! upToNow.isEmpty()}
        */
        
        // BFS from solution:
        // since it's BFS, se can use queue for traversal;
        if(mat == null || mat.length == 0 || mat[0].length == 0) return new int[0][0];
        int m = mat.length, n = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int MAX_VALUE = m * n;
        // traverse 1 time;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(mat[i][j] == 0) queue.offer(new int[]{i, j}); // upToNow[i][j] = 0;
                else mat[i][j] = MAX_VALUE;
            }
        }
        
        // Use queue to traverse twice;
        // really useful when need to go 4 directions:
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            for(int[] dir : directions){
                int r = cell[0] + dir[0], c = cell[1] + dir[1];
                if( r >= 0 && r < m && c >=0 && c < n && mat[r][c] > mat[cell[0]][cell[1]] + 1){
                    queue.offer(new int[]{r, c});
                    mat[r][c] = mat[cell[0]][cell[1]] + 1;
                }
            }
        }
        return mat;
        
        
        
        
        
        
        
            
        
    }
}