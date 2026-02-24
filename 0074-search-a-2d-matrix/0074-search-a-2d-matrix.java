class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // use binary search in the first column
        int m = matrix.length;
        int n = matrix[0].length;
        if(m == 1 && n == 1) return target == matrix[0][0];
        if(target < matrix[0][0] || target > matrix[m - 1][n - 1]) return false;
        int[] arr = new int[m * n];
        int up = 0;
        int down = m;
        // for column
        while(up < down){
            int mid = (up + down) / 2;
            if(matrix[mid][0] == target) return true;
            else if(matrix[mid][0] > target) down = mid;
            else up = mid + 1;
        }
        // for row up - 1
        int left = 0;
        int right = n;
        while(left < right){
            int mid = (left + right) / 2;
            if(matrix[up - 1][mid] == target) return true;
            else if(matrix[up - 1][mid] > target) right = mid;
            else left = mid + 1;
        }
        return false;

        

        




        
    }
}