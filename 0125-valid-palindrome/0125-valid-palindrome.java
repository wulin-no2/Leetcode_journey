class Solution {
    public boolean isPalindrome(String s) {
        // 1. remove all the non-alphanumeric character;
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < s.length() ; j++){
            char ch = s.charAt(j);
            if(Character.isLetterOrDigit(ch)) {sb.append(Character.toLowerCase(ch));};
        }
        
        // 2. 2pointers;
        int i = 0;
        int j = sb.length()-1;
        while(i<=j){
            if(sb.charAt(i)==sb.charAt(j)) {i++;j--;}
            else{return false;};
        }
        return true;

    }
}