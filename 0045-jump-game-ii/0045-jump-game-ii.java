class Solution {
    public int jump(int[] nums) {
        // for each position, record the smallest count we reach here, and the furtherest index we can reach, until furtherest >= length - 1;
        /*
        if(nums.length==1) return 0;
        int count = 1;
        int furtherest = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(i == furtherest) count++;
            furtherest = Math.max(furtherest, nums[i] + i); 
        }
        return count;
        */
    
        
        int count = 0;
        int curFar = 0;
        int nexFar = 0;
        for (int i = 0; i <= curFar && curFar < nums.length - 1; i++) {
            nexFar  = Math.max(nexFar , i + nums[i]);
            // 可达位置的改变次数就是跳跃次数
            if (i == curFar) {
                curFar = nexFar ;
                count++;
            }
        }
        return count;
    }
}