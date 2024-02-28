class Solution {
    public int wiggleMaxLength(int[] nums) {
        //find result until now;
        if(nums.length == 1) return nums.length;
        // we need to use 2 pointers;
        int curDiff = 0;
        int preDiff = 0;
        int count = 0;
        for(int i = 1 ; i < nums.length; i++){
            curDiff = nums[i] - nums[i-1];
            if((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)){
                count++;
                preDiff = curDiff;
            }
        }
        return count + 1;
    }
}

