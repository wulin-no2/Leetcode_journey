class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // make it into 1D array
        // Binary search
        int m = matrix[0].length;
        int n = matrix.length;
        if(target < matrix[0][0] || target > matrix[n-1][m-1]) return false;
        int left = 0;
        int right = n;
        while(left < right){
            int mid = (left + right) / 2;
            if(target == matrix[mid][0]) return true;
            if(target < matrix[mid][0]) right = mid;
            else left = mid + 1;
        }
        // for line left
        int l = 0;
        int r = m;
        while(l < r){
            int mid = (l + r) / 2;
            if(target == matrix[left - 1][mid]) return true;
            if(target < matrix[left - 1][mid]) r = mid;
            else l = mid + 1;
        }
        return false;
        
    }
}