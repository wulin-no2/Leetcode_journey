class Solution {
    
    public boolean canPartition(int[] nums) {
        if(nums.length == 1) return false;
        // find subarray so that their sum is half the original array;
        int sum = 0;
        for(int num: nums) sum += num;
        if(sum % 2 != 0) return false;
        
        // if sum is even:
        sum = sum / 2;
        //System.out.println("sum = " + sum);
        int n = nums.length - 1;
        // dp[i][j] means from (nums[0] to nums[i]), can we get sum = j;
        // return dp[nums[n - 1][sum]];
        // dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
        boolean[][] dp = new boolean[n + 1][sum + 1];
        // initialize:
        
        for(int i = 0 ; i <= n ; i++) {
            dp[i][0] = true;
            
        }
        //System.out.print("i = 0 ");
        for(int j = 1 ; j <= sum ; j++) {
            if(j == nums[0]) dp[0][j] = true;
            else dp[0][j] = false;
            //System.out.print(dp[0][j] +" ");
        }
        //System.out.println("");
        for( int i = 1 ; i <= n ; i++){
            //System.out.print("i = " + i + " ");
            for(int j = 1 ; j <= sum ; j++) {
                if(j >= nums[i]) dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                else dp[i][j] = dp[i - 1][j];
                //System.out.print(dp[i][j] +" ");
            }
            //System.out.println("");
        }
        return dp[n - 1][sum];
        

        

        
        
        /*
        // 1) sum must be even, or return false;
        // 2) find sub array so that their sum is sum/2;
        // dp[subsum] in array = dp[subsum-array[n-1]] or dp[subsum] in subarray;
        // calculate sum:
        int sum = 0;
        for(int i =0 ; i < nums.length ; i++) sum = sum + nums[i];
        if (sum % 2 != 0) return false;
        // 2) state transition equation:
        sum = sum / 2;
        // find if we can find sum of some elements from the array;
        boolean[] dp = new boolean[sum + 1];
        // the key part of dp solution:
        // why dp[0] is true?
        // why traverse from sum to num;
        dp[0] = true;
        for (int num : nums) {
            for (int j = sum; j >= num ; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[sum];
        */
    }
}
