class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] pre = new int[nums.length];
        // traverse once to get prefix products
        for(int i = 0; i < nums.length; i++){
            pre[i] = 1;
            if(i > 0) pre[i] = nums[i - 1] * pre[i - 1];
        }
        int[] suf = new int[nums.length];
        // traverse twice to get suffix products & results
        for(int i = nums.length - 1; i >= 0 ; i--){
            suf[i] = 1;
            if(i < nums.length - 1) suf[i] = nums[i + 1] * suf[i + 1];
        }
        for(int i = nums.length - 1; i >= 0 ; i--){
            pre[i] = pre[i] * suf[i];
        }
        return pre;
        
    }
}