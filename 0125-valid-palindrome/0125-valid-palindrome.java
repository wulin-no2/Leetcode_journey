class Solution {
    public boolean isPalindrome(String s) {
        // we use 2 pointers going forward
        int p1 = 0;
        int p2 = s.length() - 1;
        // we walk through this string
        while(p1 < p2){
            // if char is not digit or letter, move pointer
            if(!Character.isLetterOrDigit(s.charAt(p1))) p1++;
            else if(!Character.isLetterOrDigit(s.charAt(p2))) p2--;
            else if(Character.isLetterOrDigit(s.charAt(p1)) && Character.isLetterOrDigit(s.charAt(p2))){
                // if it is, compare two chars
                // if they are different, return false
                if(Character.toLowerCase(s.charAt(p1)) != Character.toLowerCase(s.charAt(p2))) return false;
                else{
                    p1++;
                    p2--;
                }
            }
        }
        return true;
    }
}