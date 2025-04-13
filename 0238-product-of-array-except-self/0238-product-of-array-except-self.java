class Solution {
    public int[] productExceptSelf(int[] nums) {
        // we traverse twice: one pass to get the prefix, one pass to get the suffix
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            // one pass
            if(i == 0) prefix[i] = 1;
            else prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        for(int i = nums.length - 1; i >= 0; i--){
            if(i==nums.length - 1) suffix[i] = 1;
            else suffix[i] = suffix[i + 1] * nums[i + 1];
        }
        for(int i = 0; i < nums.length; i++){
            prefix[i] = prefix[i] * suffix[i];

        }
        return prefix;
        
    }
}