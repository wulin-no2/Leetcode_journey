class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        if(nums[0] < nums[n-1]) return nums[0];
        // there exist two parts 
        // find the value that left one bigger than it
        int left = 1;
        int right = n;
        while(left < right){
            int mid = (left + right) / 2;
            if(nums[mid - 1] > nums[mid]) return nums[mid];
            if(nums[mid - 1] < nums[mid] && nums[mid] > nums[0]){left = mid + 1;}// right part
            else right = mid;
        }
        return nums[left];
        
    }
}