class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // convert matrix into a 1D array, then binary search
        int m = matrix.length;
        int n = matrix[0].length;
        int[] arr = new int[m*n];
        int index = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0 ; j < n ; j++){
                arr[index] = matrix[i][j];
                index++;
            }
        }
        // binary search;
        int left = 0;
        int right = m*n;
        while(left < right){
            int mid = (left + right) / 2;
            if(arr[mid]==target) return true;
            if(arr[mid] < target) left = mid + 1;
            if(arr[mid] > target) right = mid;
        }
        return false;
        
    }
}