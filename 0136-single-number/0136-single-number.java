class Solution {
    public int singleNumber(int[] nums) {
        // use hashing
        // Map<Integer, Integer> map = new HashMap<>();
        // for(int num: nums){
        //     map.put(num, map.getOrDefault(num, 0) + 1);
        // }
        // for(Map.Entry<Integer, Integer> entry: map.entrySet()){
        //     if(entry.getValue()==1) return entry.getKey();
        // }
        // return -1;
        
        int result = 0; // Initialize result
        for (int num : nums) {
            result ^= num; // XOR each number
        }
        return result; // Return the single number
        
    }
}