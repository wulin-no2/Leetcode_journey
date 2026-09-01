class Solution {
    public int findDuplicate(int[] nums) {
        // treat this array as a linkList. each value points to a node with the index;
        // duplicate values means 2 nodes point to the same node, which is a cycle in a linkList;
        // we have to find the start of the cycle
        int fast = nums[0];
        int slow = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        int slow2= nums[0];
        while(slow != slow2){
            slow = nums[slow];
            slow2 = nums[slow2];
        }
        return slow;
    }
}