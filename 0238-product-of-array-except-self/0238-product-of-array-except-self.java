class Solution {
    public int[] productExceptSelf(int[] nums) {
        // 2/3 passes
        // first pass, use array to store prefix product of each element
        // second pass, use array to store suffix product of each element
        // finally, multiple them, get result
        int n = nums.length;
        int[] prefix = new int[n];
        Arrays.fill(prefix, 1);
        int[] suffix = new int[n];
        Arrays.fill(suffix, 1);
        // first pass
        for(int i = 1;i < n; i++){
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        // second pass
        for(int i = n - 2; i >= 0; i--){
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        // get result
        for(int i = 0; i < n; i++){
            prefix[i] = prefix[i] * suffix[i];
        }
        return prefix;

        
    }
}