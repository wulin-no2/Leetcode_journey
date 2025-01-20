class Solution {
    public int maxProduct(int[] nums) {
        // 0-1 knapsack

        int n = nums.length;
        if(n==1) return nums[0];
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0]; 
        // if nums[i] is negative, min * nums[i] is the maximum;
        // if nums[i] is positive, max * nums[i] is the maximum;
        int[] dp = new int[n + 1];
        for(int i = 1 ; i < nums.length ; i++){
            int num = nums[i];

            // Temporarily store maxProduct since it will be updated
            int tempMax = maxProduct;

            // Update maxProduct and minProduct
            maxProduct = Math.max(num, Math.max(maxProduct * num, minProduct * num));
            minProduct = Math.min(num, Math.min(tempMax * num, minProduct * num));

            // Update the global maximum product
            result = Math.max(result, maxProduct);
        }
        return result;
         
    }
}