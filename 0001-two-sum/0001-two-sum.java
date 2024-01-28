class Solution {
    public int[] twoSum(int[] nums, int target) {
        // put num into map. then find target - num; and return their index;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            int temp = target - nums[i];
            if(map.containsKey(temp)) return new int[]{map.get(temp), i};
            map.put(nums[i], i);
        }
        return new int[2];
    }
    
}      
        
        
        
       
        /* the third time: 20231107 11:22
        // analyze:
        // use array to store every complement into the index of the new array; put the index as the new value:
        // check if newl(complement) is null; if it is, then put the original index as the value; if it's not, then return the value of new index and current index;
        

        int[] newl = new int[2000000000];
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            // how to check if newl[complement] is an int
            // !!!!!!the problem is, new array must have a length of [2000000000];
            // so how to check???
            if(newl[complement] >= -1000000000 && newl[complement] <= 1000000000){
                result[1] = newl[complement];
                result[0] = i;
                return result;
            }
            else{
                newl[complement] = i;
            }
        }
        return result;*/
        
