class Solution {
    public List<Integer> partitionLabels(String s) {
        // partition them in one-element parts;
        // then merge;
        List<Integer> res = new ArrayList<>();
        int[] nums = new int[26]; // used to record which position each letter is in
        char[] chars = s.toCharArray();
        for(int i = 0 ; i < s.length() ; i++){
            nums[chars[i] - 'a'] = i;// update the latest position of each letter
        }
        // now we have latest position of each letter;
        // partition intervals;
        int index = 0;
        int last = -1; // end of last interval;
        for(int i = 0 ; i < s.length() ; i++){
            index = Math.max(index, nums[chars[i] - 'a']); // find largest position of current interval
            if(i == index){
                res.add(i - last);
                last = i;
            }
        }
        return res;
    }
}