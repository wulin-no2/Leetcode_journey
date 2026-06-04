class Solution {
    public int findMin(int[] nums) {
        // FFFFFF[T]TTT
        // find the first small one
        // binary search
        int left = 0;
        int right = nums.length - 1;
        while(left < right){ // element before left can't be the answer
            int mid = left + (right - left) / 2;
            // we have to find something unchanged
            if(nums[mid] > nums[right]){
                // mid in left part
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return nums[left];
    }
}