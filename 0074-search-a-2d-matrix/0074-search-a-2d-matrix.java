class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // binary search
        // make it into a 1D array
        int m = matrix.length;
        int n = matrix[0].length;
        int[] arr = new int[m * n - 1];
        if(target < matrix[0][0] || target > matrix[m - 1][n-1]) return false;
        int left = 0;
        int right = m * n;
        while(left < right){
            int mid = (right + left) / 2;
            // compare matrix[][] vs target
            int row = mid / n;
            int col = mid % n;
            if(matrix[row][col] == target) return true;
            if(matrix[row][col] > target) right = mid;
            else left = mid + 1;
        }
        return false;
        
    }
}