class Solution {
    public int[] twoSum(int[] nums, int target) {
        /* the first time: 20230911
        int[] index = {0,0};
        for(int i = 0; i < nums.length; i ++){
            for(int j = i + 1; j < nums.length; j ++){
                if (nums[j] == target - nums[i]){
                    index[0] = i;
                    index[1] = j;
                    return index;
                }
            }
        } 
        return index;
        */
        
        /* the second time: 20231107 10:58
        // analyze: 
        // use a Hashmap
        (from discuss. got it at 11:21)
                */
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
        
        
        /* the third time: 20231107 11:22
        // analyze:
        // use array to store every complement into the index of the new array; put the index as the new value:
        // check if newl(complement) is null; if it is, then put the original index as the value; if it's not, then return the value of new index and current index;
        

        int[] newl = new int[nums.length]
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
        return result;
        */
    }
}