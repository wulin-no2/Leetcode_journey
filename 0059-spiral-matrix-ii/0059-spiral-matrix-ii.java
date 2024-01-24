class Solution {
    public int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];
        int startX = 0, startY = 0;  // each loop start point
        int offset = 1;  
        int count = 1;  // the number in the matrix
        int loop = 1; // count loop from 1;
        int i, j;

        while (loop <= n / 2) { 
            // j is the colomn, i is the row;
            
            // for the top edge
            // left close, right open; j != n - offset
            for (j = startY; j < n - offset; j++) {
                nums[startX][j] = count++;
            }

            // the right edge, 
            // left close, right open; i != n - offset
            for (i = startX; i < n - offset; i++) {
                nums[i][j] = count++;
            }

            // the bottom edge
            // left close, right open; j != startY
            for (; j > startY; j--) {
                nums[i][j] = count++;
            }

            // the left edge
            // left close, right open; i != startX
            for (; i > startX; i--) {
                nums[i][j] = count++;
            }
            startX++;
            startY++;
            offset++;
            loop++;
        }

        if (n % 2 == 1) {
            nums[startX][startY] = count;
        }

        return nums;
    }
}