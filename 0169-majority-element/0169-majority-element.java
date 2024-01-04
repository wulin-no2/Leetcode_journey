class Solution {
    public int majorityElement(int[] nums) {
        // analyze:
        // use hashmap to store the times and values of elements;
        // use int maxTimes to store the max times;
        // get the result, marjorNum;
        int maxTimes = 0;
        int majorNum = nums[0];
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            // see if the number already appears;
            int currentCount = hashmap.getOrDefault(nums[i], 0) + 1;
            hashmap.put(nums[i], currentCount);
            
            // see if maxTimes and majorNum should be changed;
            if (currentCount > maxTimes) {
                maxTimes = currentCount;
                majorNum = nums[i];
            }
        }
        return majorNum;
    }
}