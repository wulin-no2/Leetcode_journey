class Solution {
    public int findDuplicate(int[] nums) {
        // sort it;
        // see if nums[i] == nums[i + 1]
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-1 ; i++){
            if(nums[i]==nums[i+1]) return nums[i];
        }
        return -1;   
    }
}