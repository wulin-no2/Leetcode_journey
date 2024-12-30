class Solution {
    public int rob(int[] nums) {
        // dp
        // arr[i] = Math.max(arr[i-1], arr[i-2] + nums[i]);
        int n = nums.length;
        int[] arr = new int[n+1]; 
        if(n==1) return nums[0];
        arr[0] = nums[0]; 
        arr[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n; i++){
            arr[i] = Math.max(arr[i-1], arr[i-2] + nums[i]);
        }
        return arr[n-1];
    }
}