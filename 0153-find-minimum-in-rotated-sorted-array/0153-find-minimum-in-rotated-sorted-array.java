class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length;
        if(nums[left] <= nums[right - 1]) return nums[left];
        if(nums[right - 1] < nums[right - 2]) return nums[right - 1];
        right--;
        // now we have to find a pattern that nums[i] > nums[i + 1] then return nums[i + 1]
        while(left < right){
            int mid = (right - left) / 2 + left;
            if(nums[mid] > nums[mid + 1]) return nums[mid + 1];
            else if(nums[mid] < nums[0]) right = mid; // right half
            else left = mid + 1;  // left half
        }
        return nums[left];   
    }
}