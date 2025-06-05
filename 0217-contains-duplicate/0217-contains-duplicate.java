class Solution {
    public boolean containsDuplicate(int[] nums) {


        // hashing array, hashset, hashmap to detect duplicated element
        // traverse from left to right
        // use hashset cause the element's range is big
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums){
            if(set.contains(num)) return true;
            set.add(num);

        }
        return false;
        
    }
}