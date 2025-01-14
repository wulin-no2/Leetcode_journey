class Solution {
    public int search(int[] nums, int target) {
        // binary search
        int n = nums.length;
        if(n==1) return target == nums[0]? 0: -1;
        // now there is a pivot, binary search
        int left = 0;
        int right = n;
        while(left < right){
            int mid = (left + right) / 2;
            if(nums[mid]==target) return mid;
            if(target >= nums[0]){ //left part
                if(nums[mid] > target) right = mid;
                else if(nums[mid] < target && nums[mid] >= nums[0]) left = mid + 1;
                else right = mid;
            } 
            else{ // right part
                if(nums[mid] < target) left = mid + 1;
                else if(nums[mid] > target && nums[mid] < nums[0]) right = mid;
                else if(nums[mid] > target && nums[mid] >= nums[0])left = mid + 1;
            }
        }
        return -1;  
    }
}