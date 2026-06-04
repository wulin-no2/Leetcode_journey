class Solution {
    public int findMin(int[] nums) {
        //1. leftmost one if the smallest(rightmost > leftmost)
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        if(nums[right] >= nums[left]) return nums[0];
        //2. or left > this(rightmost < leftmost)
        left = 1;
        while(left < right){
            int mid = (left + right) / 2;
            if(nums[mid] < nums[mid - 1]) return nums[mid];
            else if(nums[mid] > nums[right]) { // left half 
                left = mid + 1;
            } else right = mid;
        }
        return nums[left];
    }
}