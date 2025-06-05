class Solution {
    public boolean containsDuplicate(int[] nums) {


        // hashing array, hashset, hashmap to detect duplicated element
        // traverse from left to right
        // use hashset cause the element's range is big
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums){  // 0(N)
            if(set.contains(num)) return true; // 0(1)
            set.add(num); // 0(1)

        }
        return false;
        // space complexity: O(N) worst 
        
        
    }
}