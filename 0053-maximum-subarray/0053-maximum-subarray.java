class Solution {
    public int maxSubArray(int[] nums) {
        // analyze:
        // we can use kadane's algorithm;
        // use 2 int and 2 LinkedList to store arrays;
        // 1) int max_ending_here
        // 2) int max
        // update step by step
        
        /*
        int maxEndingHere = nums[0];
        int max = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            if(maxEndingHere + nums[i] > nums[i]){
                maxEndingHere = maxEndingHere + nums[i];
            }else{
                maxEndingHere = nums[i];
            }
            
            if(max < maxEndingHere){
                max = maxEndingHere;
            } 
        }
        return max;
        */
        
        
        // there are other 2 approaches;
        // Dynamic Programming
        /*
        int maxArray []=  new int[nums.length];
        int max  =  nums[0];
        maxArray[0] =  nums[0];
        for(int i = 1; i < nums.length; i++){
           maxArray[i] = Math.max(maxArray[i-1] + nums[i], nums[i]);
           max = Math.max(maxArray[i], max);
        }
        return max;   
        */
        int max = nums[0];
        int maxCur = max;
        for(int i = 1; i < nums.length; i++){
            maxCur = Math.max(maxCur + nums[i], nums[i]);
            max = Math.max(maxCur, max);
        }
        return max;
    }
}