class Solution {
    public int longestPalindrome(String s) {
        // use array hashing
        int[] arr = new int[128];
        // traverse
        for(char c: s.toCharArray()){
            arr[c]++;
        }
        // count
        int count = 0;
        int hasOdd = 0;
        for(int i: arr){
            if(i % 2 == 0) count += i;
            else{
                count += i - 1;
                hasOdd = 1;
            }
        }
        return count+hasOdd;
    }
}