class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // we can use DFS and BFS, we can use recursive and iterative. Let's see how to do it.
        // first, recursive approach:
        // find the 4 directionally pixel with same color. then make them floodFill();
        // create a new 2D array as result;
        /* can't do it. following is wrong.
        int m = image.length;
        int n = image[0].length;
        int[][] res = new int[m-1][n-1];
        
        // for int[sr][sc], find the 4 directionally pixel;
        // what is base case?
        if(sr + 1 < m && image[sr][sc] == image[sr + 1][sc]){
        res = floodFill(image, sr + 1, sc, color);
        }
        if(sc + 1 < n && image[sr][sc] == image[sr][sc + 1]){
        res = floodFill(image, sr, sc + 1, color);
        }
        if(sr - 1 >= 0 && image[sr][sc] == image[sr - 1][sc]){
        res = floodFill(image, sr - 1, sc, color);
        }        
        if(sc - 1 >= 0 && image[sr][sc] == image[sr][sc - 1]){
        res = floodFill(image, sr, sc - 1, color);
        }
        return res;
        */
        
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
}