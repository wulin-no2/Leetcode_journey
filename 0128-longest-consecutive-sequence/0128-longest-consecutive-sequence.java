class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        // use hashset
        // if num - 1 not in set, maybe it's a start of sequence. then we find num,num+1..
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        for(int num: set){
            if(! set.contains(num-1)){
                int longest = 1;
                num++;
                while(set.contains(num)){
                    longest++;
                    num++;
                    
                }
                res = Math.max(res, longest);
            }
        }
        return res;
        
    }
}