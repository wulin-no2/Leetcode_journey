class Solution {
    public int findMin(int[] nums) {
        // find the first small one. FFFFTTTTTT 
        // Binary search 
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[right]){
                // mid must be in the left half
                left = mid + 1;
            }else right = mid;
        }
        return nums[left];
        
    }
}