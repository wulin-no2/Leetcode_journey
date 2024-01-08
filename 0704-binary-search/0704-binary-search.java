class Solution {
    public int search(int[] nums, int target) {
        // analyze:
        // binary search:
        // use 3 pointers: low, high, mid;
        // change low and high, check mid;
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return -1;
        
    }
}