class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        // 2pointers
        int left = 0;
        int right = s.length()-1;
        while(left < right){
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while(left < right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            char l = s.charAt(left);
            char r = s.charAt(right);
            if(l!=r) return false;
            left++;
            right--;
            
        }
        return true;
        
    }
}