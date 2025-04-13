class Solution {
    public int longestConsecutive(int[] nums) {

        int res = 0;
        // key point is, we could put all the elements in a set
        // for each element, if element -1 is not in the set, it can be a start of a consecutive sequence
        // traverse the array until get the result
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums) set.add(num);
        for(int num: set){
            if(set.contains(num - 1)) continue;
            int length = 0;
            while(set.contains(num)){
                length++;
                num++;
            }
            res = Math.max(res, length);
        }
        return res;
    }
}