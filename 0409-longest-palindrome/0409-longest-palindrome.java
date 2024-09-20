class Solution {
    public int longestPalindrome(String s) {
        // hashing
        // count each digits, we can use all the even count nunmbers（+ 1 odd count number）
        // hashing
        HashMap<Character, Integer> map = new HashMap<>();
        // traverse and put elements into map
        // Traverse the string and populate the HashMap
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // count the even count numbers
        int hasOdd = 0;
        int count = 0;
        for(int i: map.values()){
            if(i % 2 == 0) count += i;
            else {
                count += i - 1;  // Add the largest even part of odd counts
                hasOdd = 1;  // Mark that there's at least one odd count}
            }
        }
        return count + hasOdd;
        
    }
}
