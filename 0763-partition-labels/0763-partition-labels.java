class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int[] nums = new int[26]; // used to record which position each letter is in
        char[] chars = s.toCharArray();
        //first pass: find the latest position of each letter
        for(int i = 0 ; i < s.length() ; i++){
            nums[chars[i] - 'a'] = i;
        }
        // second pass:
        // partition intervals;According to the largest position of current interval
        int index = 0;
        int last = -1; // end of last interval;
        for(int i = 0 ; i < s.length() ; i++){
            index = Math.max(index, nums[chars[i] - 'a']); 
                // if i equals largest position of current interval, split it;
            if(i == index){
                res.add(i - last);
                last = i;
            }
        }
        return res;

    }
}