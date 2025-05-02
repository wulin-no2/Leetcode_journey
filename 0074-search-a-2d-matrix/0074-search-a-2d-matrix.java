class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // binary search
        // turn it into 1d array first
        int m = matrix.length;
        int n = matrix[0].length;
        int[] arr = new int[m * n];
        for(int i = 0; i < m; i++){
            int k = i * n;
            for(int j = 0; j < n; j++){
                arr[k] = matrix[i][j];
                k++;
            }
        }
        // binary tree
        int left = 0;
        int right = arr.length;
        while(left < right){
            int mid = (left + right) / 2;
            if(arr[mid] == target) return true;
            else if(arr[mid] > target) right = mid;
            else left = mid + 1;
        }
        return false;


        
    }
}