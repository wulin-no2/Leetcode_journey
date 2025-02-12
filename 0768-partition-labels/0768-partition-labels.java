class Solution {
    public List<Integer> partitionLabels(String s) {
        // first pass: traverse, record the last index that element came up;
        int[] position = new int[26];
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            position[c-'a'] = i;
        }
        // second pass: mark the farthest index current part can reach
        // until i == farthest, divide it
        int farthest = 0;
        int start = 0;
        List<Integer> res = new ArrayList<>();
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            farthest = Math.max(farthest, position[c-'a']);
            if(i==farthest) {res.add(i - start + 1); start = i + 1;}
            
        }
        return res;

        
    }
}