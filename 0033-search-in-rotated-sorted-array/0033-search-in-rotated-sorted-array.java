class Solution {
    public int search(int[] nums, int target) {
        // binary search, find a target, left close right close
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return mid;
            // find something stable. There's always one side is in order, find it
            // if left side is in order
            if(nums[mid] >= nums[left]){
                // see if target is between them
                if(target >= nums[left] && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
            } else { // if right side is in order
                // see if target is between right and mid
                if(target > nums[mid] && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
     return -1;
    }
}