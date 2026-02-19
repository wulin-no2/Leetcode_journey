class Solution {
    public boolean isPalindrome(String s) {
        // two pointers
        // traverse from two ends inward
        // if it's a non-alphanumeric character, move the pointer
        // convert it into lowercase and compare
        // if they're the same, move inward together, if not, return false
        int p1 = 0;
        int p2 = s.length() - 1;
        while (p1 < p2){
            while(p1 < p2 && !Character.isLetterOrDigit(s.charAt(p1))){
                p1++;
            }
            while(p1 < p2 && !Character.isLetterOrDigit(s.charAt(p2))){
                p2--;
            }
            if(p1 < p2) {
                if(Character.toLowerCase(s.charAt(p1)) != Character.toLowerCase(s.charAt(p2))) return false;
                else {
                    p1++;
                    p2--;
                }
            }
        }
        return true;
    }
}