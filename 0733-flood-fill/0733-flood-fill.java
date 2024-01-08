class Solution {
    // can't do it. 
    /* method from GPT. time complexity is O(n), space is O(n)
    

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // we can use DFS and BFS, we can use recursive and iterative. Let's see how to do it.
        // first, recursive approach:
        // find the 4 directionally pixel with same color. then make them floodFill();
        // create a new 2D array as result;

        int currentColor = image[sr][sc];
        if (currentColor != color) {
            dfs(image, sr, sc, currentColor, color);
        }
        return image;
    }
    private void dfs(int[][] image, int r, int c, int currentColor, int color) {
        // Check for out of bounds and if the current pixel is of the target color
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != currentColor) {
            return;
        }

        // Change the color
        image[r][c] = color;

        // Recursive calls for adjacent pixels
        dfs(image, r + 1, c, currentColor, color);
        dfs(image, r - 1, c, currentColor, color);
        dfs(image, r, c + 1, currentColor, color);
        dfs(image, r, c - 1, currentColor, color);
    }
    */
    
    // another BFS approach from discuss:
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int target = image[sr][sc];image[sr][sc] = newColor;
        if(target == newColor){
            return image;
        }

        final int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
        Queue<int[]> queue = new LinkedList<>();
//        Queue<int[]> visited = new LinkedList<>();
        queue.add(new int[]{sr,sc});

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
//            visited.add(cur);
            for(int[] dir : directions){
                int row = cur[0] + dir[1];
                int col = cur[1] + dir[0];
//                if(isVaild(row,col,image,target) && !visited.contains(new int[]{row,col})){
                if(isVaild(row,col,image,target)){// target must != newColor,so if isVaild(row,col,image,target) is false, means this point is visited.
                    image[row][col] = newColor;
                    queue.add(new int[]{row,col});
                }
            }
        }
        return image;
    }

    private boolean isVaild(int row,int col,int[][] image,int target){
        if(row >= image.length || row < 0 || col >= image[0].length || col < 0 || image[row][col] != target){
            return false;
        }
        return true;
    }
}