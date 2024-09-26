class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet set = new HashSet<>();
        // use set to check if there is alreay this elements
        for(int num: nums){
            if(set.contains(num)) return true;
            set.add(num);
        }
        return false;
        
    }
}