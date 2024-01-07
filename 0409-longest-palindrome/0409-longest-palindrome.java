class Solution {
    public int longestPalindrome(String s) {
        // analyze:
        // if we want to get palindrome, except the middle one, each letters should appear even times.
        // transfer string to array;
        // We don't care the order. so, we can use a hashset and a count;
        // traverse:
        // if letter is in the hashset, remove it, count++;
        // else, add it into hashset;
        // in the end, if the size of hashset isn't 0; 
        // the result should be count * 2 + 1;
        // else the result should be count * 2
        // time complexity should be O(n), space is O(n);
        char[] charS = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        
        for(char c: charS){
            if(set.contains(c)){
                set.remove(c);
                count++;
            }else{
                set.add(c);
            }
        }
        if(set.size() != 0){
            return count * 2 + 1;
        }
        return count * 2;
        
        
        
    }
}