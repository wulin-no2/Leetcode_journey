class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // it can be seen as a 1D non-decreasing array 
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n; // left closed right open
        while(left < right){
            int mid = (right - left) / 2 + left;  // index
            // find the val
            int row = mid / n;
            int col = mid % n;
            int val = matrix[row][col];
            if(val == target) return true;
            else if(val > target) right = mid;
            else left = mid + 1;
        }
        return false;
     
    }
}