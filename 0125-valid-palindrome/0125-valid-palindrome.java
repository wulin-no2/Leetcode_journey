class Solution {
    public boolean isPalindrome(String s) {
        // analyze:
        // 1. translate them into lowercase and remove the non-alphanumeric characters
        // store it into 2 arrayLists in different orders;
        // compare them;
        // time: O(n); space:O(n)
        /* following is my solution using 2 ArrayLists;
        
        char[] charS = s.toCharArray();
        ArrayList<Character> arr = new ArrayList<>();
        for(char a : charS){
            if((a >='0' && a <= '9') || (a >='a' && a <= 'z')){
                arr.add(a);
            }else if((a >='A' && a <= 'Z')){
                arr.add(Character.toLowerCase(a));
            }
        }
        ArrayList<Character> arr1 = new ArrayList<>(arr);
        Collections.reverse(arr1);
        return arr.equals(arr1);
        */
        
        // we can directly use 2 pointers to compare, which is easier:
        // we have to use Character.isLetterOrDigit(a) method;
        // if it's LetterOrDigit, 2 pointers move simultaneously, and compare;
        // if it's not, don't move;
        //
        int p1 = 0;
        int p2 = s.length() - 1;
        while(p1 <= p2){
            // !!!there must be p1 <= p2!!!
            while(p1 <= p2 && !(Character.isLetterOrDigit(s.charAt(p1)))){
                p1++;
            }
            while(p1 <= p2 && !(Character.isLetterOrDigit(s.charAt(p2)))){
                p2--;
            }
            if(p1 <= p2 &&( 
                (Character.toLowerCase(s.charAt(p1))) != (Character.toLowerCase(s.charAt(p2))) )){
                return false;
            }
            // after comapare, p1 and p2 must move!!!
            p1++;
            p2--;
        }
        return true;  
    }
}