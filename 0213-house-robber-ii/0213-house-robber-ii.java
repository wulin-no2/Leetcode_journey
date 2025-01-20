class Solution {
    public int rob(int[] nums) {
        // simplify this problem into 2 small problems
        // 1. don't rob first house, get the maximum money
        // 2. don't rob last house, get the maximum money
        // 3. math.max
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);
        int exFirst = robHelper(nums, 1, n - 1);
        int exLast = robHelper(nums, 0, n - 2);
        return Math.max(exFirst, exLast);
    }
    public int robHelper(int[] nums, int start, int end){
        int[] dp = new int[nums.length];
        // dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        for(int i = start + 2; i < end + 1; i++){
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[end];
    }
}