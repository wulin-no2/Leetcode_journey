class Solution {
    public int search(int[] nums, int target) {
        int right = nums.length - 1; 
        int left = 0;
        
        while(left <= right){
            int mid = (left + right)/2;
            if(target < nums[mid]) right = mid - 1;
            else if(target > nums[mid]) left = mid + 1;
            else return mid;
        }
        return -1;
        
    }
}