class Solution {
    public boolean containsDuplicate(int[] nums) {
        // add elements of the array into arrayList.
        // use contains to check if an element is in the arrayList.
        
        // No!! We should use hashset to add and check.
        // Cause it's more efficient to add elements with hashset. and the elements in hashset can't duplicate.
        HashSet<Integer> set = new HashSet<>();
        for(Integer num: nums){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;
    }
}