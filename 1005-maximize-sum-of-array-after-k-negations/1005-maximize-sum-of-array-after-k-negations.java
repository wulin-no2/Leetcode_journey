class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        // 1) for all the negative values, choose it from small to big
        // 2) if all the negative values are done. see the remaining k is even or odd; if it's even, return sum; if it's odd, subtract the smallest value and return;
        Arrays.sort(nums);
        int smallest = 101;
        for (int i = 0; i < nums.length && k > 0; i++) {
            if (nums[i] < 0) { nums[i] = -nums[i];k--;}
            smallest = Math.min(smallest, nums[i]);
        }
        int sum = 0;
        for (int num : nums) sum += num;
        if (k % 2 == 1) sum -= 2 * smallest;
        return sum;   
    }
}