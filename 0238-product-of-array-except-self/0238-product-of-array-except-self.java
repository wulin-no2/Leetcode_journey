class Solution {
    public int[] productExceptSelf(int[] nums) {
        // if we traverse once, we can either get the product of the prefix or the suffix
        // so we have to traverse twice in different order
        // then multiple them:
        int length = nums.length;
        int[] prefix = new int[length];
        int[] suffix = new int[length];
        int[] res = new int[length];
        for(int i = 0 ; i < length; i++){
            if(i == 0) prefix[i] = 1;
            else prefix[i] = nums[i - 1] * prefix[i - 1];
        }
        for(int i = length - 1; i >= 0; i --){
            if(i == length - 1) suffix[i] = 1;
            else suffix[i] = nums[i + 1] * suffix[i + 1];
            res[i] = suffix[i] * prefix[i];
        }
        return res;

        
    }
}