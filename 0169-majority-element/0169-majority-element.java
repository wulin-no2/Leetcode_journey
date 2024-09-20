class Solution {
    public int majorityElement(int[] nums) {
        // sort the array, the middle one is what we want
        // Sort the array
        Arrays.sort(nums);
        return nums[nums.length/2];
        
    }
}