class Solution {
    public int findMin(int[] nums) {
        // find index so that nums[index-1] bigger than nums[index]
        // if can't find it, return nums[0]
        int left = 0;
        int right = nums.length;
        while(left < right){
            int mid = (left + right) / 2;
            if(mid == 0) return nums[left];
            // find it
            if(nums[mid-1] > nums[mid]) return nums[mid];
            if(nums[mid] > nums[right-1]) left = mid;
            else right = mid;
        }
        return nums[left];
        
    }
}