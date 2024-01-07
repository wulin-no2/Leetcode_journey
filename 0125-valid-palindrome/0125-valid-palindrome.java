class Solution {
    public boolean isPalindrome(String s) {
        // analyze:
        // 1. translate them into lowercase and remove the non-alphanumeric characters
        // store it into 2 arrayLists in different orders;
        // compare them;
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
        
    }
}