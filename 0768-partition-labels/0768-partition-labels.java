class Solution {
    public List<Integer> partitionLabels(String s) {
        // 1. record the last index of each element's occurance
        // 2. partition it 
        List<Integer> res = new ArrayList<>();
        int[] arr = new int[26]; // use to store occurance
        for(int i = 0; i < s.length() ; i++){
            char c = s.charAt(i);
            arr[c-'a'] = i;
        }
        // partition with 2 pointers
        int start = 0;
        int end = 0;
        for(int i = start; i < s.length() ; i++){
            char c = s.charAt(i);
            end = Math.max(arr[c-'a'], end);
            if(end == i) {
                res.add(end - start + 1);
                start = end + 1;
                end = start;
            }
            // System.out.println("char is: " + c + " end is: " + end + " start is: " + start);
        }
        return res;

        
        
    }
}