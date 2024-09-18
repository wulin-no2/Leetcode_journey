class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // array hashing for 26 lowercase letters
        // 1. traverse magazine and store info into array
        int[] arr = new int[26];
        for(int i = 0 ; i< magazine.length() ; i++){
            int index = magazine.charAt(i) - 'a';
            arr[index]++;
        }
        
        // 2. traverse ransomNote, if element in array is -1, return false;
        for(int i = 0 ; i< ransomNote.length() ; i++){
            int index = ransomNote.charAt(i) - 'a';
            arr[index]--;
            if(arr[index] < 0) return false;
        }
        
        // 3. after traverse, return true;
        return true;
        
    }
}