class Solution {
    public int lengthOfLIS(int[] nums) {
        // dp
        /*
        int n = nums.length;
        if(n==1) return 1;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        
        int maxLength = 1;

        for(int i = 1 ; i < n ; i++){
            for(int j = 0; j < i ; j++) if(nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
        */

        // dp + binary search
        List<Integer> list = new ArrayList<>();

        for(int num: nums){
            int pos = Collections.binarySearch(list, num);
            if(pos < 0) pos = -(pos + 1);
            if(pos < list.size()) list.set(pos, num);
            else list.add(num);
        }
        return list.size();
        
    }
}