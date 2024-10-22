class Solution {
    public int search(int[] nums, int target) {
        // binary search
        int left = 0;
        int right = nums.length;
        while(left < right){
            int mid = (left + right)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) right = mid;
            else left = mid + 1;
        }
        return -1;
    }
}