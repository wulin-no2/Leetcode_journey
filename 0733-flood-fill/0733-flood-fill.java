class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color) return image;
        traverse(image, sr, sc, image[sr][sc], color);
        return image;
    }
    //dfs
    public void traverse(int[][] image, int sr, int sc, int old, int color){
        // base case
        if(sr<0 || sc<0 || sr>= image.length || sc>=image[0].length || image[sr][sc]!=old) return;
        image[sr][sc]=color;
        traverse(image, sr-1, sc, old, color);
        traverse(image, sr+1, sc, old, color);
        traverse(image, sr, sc-1, old, color);
        traverse(image, sr, sc+1, old, color);
    }
}