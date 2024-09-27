class Solution {
    public int[][] updateMatrix(int[][] mat) {
        // use a matrix to store the result
        // if mat[i][j]==0 res[i][j]=0;
        // else use BFS to find the shortest distance of it to 0;
        // 1st pass
        int m = mat.length;
        int n = mat[0].length;
        
        // use BFS to solve it
        Queue<int[]> queue = new LinkedList<>();
        
        // Initialize the result matrix with max values for 1s, and add them into queue
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    result[i][j] = 0;
                    queue.offer(new int[]{i,j}); // store coordinate into it
                } else {
                    result[i][j] = Integer.MAX_VALUE; // Large value for 1s
                }
            }
        }
        // helper directions
        int[][] directions = {{1, 0},{-1, 0},{0, 1},{0, -1}};
        
        // BFS
        while(!queue.isEmpty()){
            // get an int[]
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];
            
            // and compare it with 4 directions
            for(int[] direction: directions){
                int newX = x + direction[0];
                int newY = y + direction[1];
             // if 4 directions > current value + 1, update 4 directions value, add it to queue 
                if(newX>=0 && newX<mat.length && newY >=0 && newY<mat[0].length){
                    if(result[newX][newY] > result[x][y] + 1){
                        result[newX][newY] = result[x][y] + 1;
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
        }

        return result;
    }
}