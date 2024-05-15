class Solution {
    public int[] twoSum(int[] nums, int target) {
        // // put num into map. then find target - num; and return their index;
        // Map<Integer, Integer> map = new HashMap<>();
        // for(int i = 0 ; i < nums.length ; i++){
        //     int temp = target - nums[i];
        //     if(map.containsKey(temp)) return new int[]{map.get(temp), i};
        //     map.put(nums[i], i);
        // }
        // return new int[2];
        
        // find 1 elements by index(array, map)
        // solution 1: brute force
        /*
        for(int i = 0; i < nums.length - 1; i++){
            int temp = target - nums[i];
            for(int j = i + 1; j < nums.length; j++){
                if(nums[j]==temp) return new int[]{i,j};
            }
        }
        return null;*/
        // solution 2: use map to remember the elements as key, put the index as value;
        // then we can get it in O(1) time;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length; i++){
            int complement = target - nums[i];
            // check if there is a key equals nums[i]
            // if exists, return result
            if(map.containsKey(nums[i])) return new int[]{i,map.get(nums[i])};
            // if not, put it in map;
            map.put(complement, i);
        }
        return new int[0];
    }
}      
        
        
