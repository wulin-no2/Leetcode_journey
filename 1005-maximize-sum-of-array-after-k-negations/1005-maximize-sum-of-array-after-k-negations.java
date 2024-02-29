class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        // 1) for all the negative values, choose it from small to big
        // 2) if all the negative values are done. see the remaining k is even or odd; if it's even, return sum; if it's odd, subtract the smallest value and return;
        
        Arrays.sort(nums);
        int i = 0;
        while(k > 0 && i < nums.length && nums[i] < 0) {nums[i] = -nums[i]; i++; k--;}
        if(k == 0) return sumArray(nums);
        if(k % 2 == 0) return sumArray(nums);
        else {Arrays.sort(nums); return sumArray(nums) - nums[0]*2;}
    }
    private int sumArray(int[] nums){
        int sum = 0;
        for(int i = 0; i<nums.length; i++) sum += nums[i];
        return sum;
    }
}