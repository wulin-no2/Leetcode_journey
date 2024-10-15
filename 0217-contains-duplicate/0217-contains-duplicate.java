class Solution {
    public boolean containsDuplicate(int[] nums) {
        // use hashSet to track duplication
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums){
            if(set.contains(num)) return true;
            set.add(num);
        }
        return false;
        
        
    }
}