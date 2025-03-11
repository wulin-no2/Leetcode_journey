class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        // use a set to store elements
        // then check one by one to see if there's concecutive elements
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        // then check one by one to see if there's concecutive elements. How to check? From the smallest one. 
        // If no one is smaller 1 than it, then it can be a start; get the following one until can't get anymore; record the length; 
        // Get next one without an element smaller 1 than 1; do the above again;
        // the set should be sorted? No. we can check one by one from the array
        for(int num: set){
            if(! set.contains(num - 1)) { // can be a start
                int count = 0;
                while(set.contains(num)) {count++; num++;}
                res = Math.max(count, res);
            }
        }
        return res;


        
    }
}