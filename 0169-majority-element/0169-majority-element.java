class Solution {
    // my own solution on 2022.1.4
    // the time complexity is O(n), but the space complexity if also O(n) 
    
//     public int majorityElement1(int[] nums) {
//         // analyze: 
//         // use hashmap to store the times and values of elements;
//         // use int maxTimes to store the max times;
//         // get the result, marjorNum;
//          int maxTimes = 0;
//          int majorNum = nums[0];
//          HashMap<Integer, Integer> hashmap = new HashMap<>();
//          for(int i = 0; i < nums.length; i++){
//             // see if the number already appears;
//             int currentCount = hashmap.getOrDefault(nums[i], 0) + 1;
//             hashmap.put(nums[i], currentCount);
            
//             // see if maxTimes and majorNum should be changed;
//             if (currentCount > maxTimes) {
//                 maxTimes = currentCount;
//                 majorNum = nums[i];
//             }
//         }
//         return majorNum;
//     }
   
    
    // the optimized solution on 2022.1.4
    // Boyer-Moore Voting Algorithm 
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    
}