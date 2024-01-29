class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // it's letters so we can use array or map;
        int[] arr = new int[26];
        for(int i = 0 ; i < magazine.length() ; i ++){
            arr[magazine.charAt(i) - 'a']++;
        }
        for(int i = 0 ; i < ransomNote.length() ; i ++){
            arr[ransomNote.charAt(i)-'a']--;
            if(arr[ransomNote.charAt(i)-'a']< 0) return false;
        }
        return true;
        
        // again, it's a string with alphametic and we have to know the count of each alphametic, so we we can use int[] to store the count of magezine
        /*
        int[] count = new int[26];
        for(char m : magazine.toCharArray()){
            count[m - 'a']++;
        }
        for(char r : ransomNote.toCharArray()){
            count[r - 'a']--;
            if(count[r - 'a'] < 0){
                return false;
            }
        }
        return true;
        */
    }
}