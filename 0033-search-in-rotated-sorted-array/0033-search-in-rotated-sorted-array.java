class Solution {
    public int search(int[] nums, int target) {
        // binary search
        int left = 0;
        int right = nums.length;
        while(left < right){
            int mid = (left + right) / 2;
            if(nums[mid]==target) return mid;
            if(nums[mid] >= nums[left]){ // left part ascending
                if(target >= nums[left] && target < nums[mid]) right = mid;
                else left = mid + 1; 
            }
            else{ // left part not ordered, right part ordered
                if(target > nums[mid] && target <= nums[right-1]) left = mid + 1;
                else right = mid;
            }
        }
        return -1;
        
    }
}