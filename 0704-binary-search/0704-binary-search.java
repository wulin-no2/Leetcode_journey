class Solution {
    public int search(int[] nums, int target) {
        // Binary Search
        int left = 0; // 0, 
        int right = nums.length; // 5

        while(left < right){ // left close right open, meaning we don't check right
            int mid = (right - left) / 2 + left; // 2, 1, 1
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) right = mid; // right open // 2
            else left = mid + 1; // we check left
        }


        return -1;
        
    }
}