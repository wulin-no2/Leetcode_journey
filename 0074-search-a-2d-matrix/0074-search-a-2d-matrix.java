class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // binary search
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n;
        while(left < right){
            int mid = (left + right) / 2;
            int row = mid / n;
            int column = mid % n;
            if(matrix[row][column] == target) return true;
            else if(matrix[row][column] > target) right = mid;
            else left = mid + 1;
        }
        return false;

        
    }
}