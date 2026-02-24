class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        // traverse the array
        for (int i : nums){
            if(set.contains(i)) return true;
            set.add(i);
        }
        return false;
        
    }
}