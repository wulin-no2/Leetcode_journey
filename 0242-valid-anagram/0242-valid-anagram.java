class Solution {
    public boolean isAnagram(String s, String t) {
        // hashing
        // cause we have 26 different elements, use array
        int[] arr = new int[26];
        for(int i = 0 ; i < s.length() ; i ++){
            arr[s.charAt(i) - 'a']++;
        }
        for(int i = 0 ; i < t.length() ; i ++){
            arr[t.charAt(i) - 'a']--;
        }
        for(int i = 0 ; i < arr.length ; i ++){
            if(arr[i] != 0) return false;
        }
        return true;
        
        
        
        
        
        
        // analyze:
        // 1. if lengths is different, return false;
        // 2. put elements of s into a hashset, then see if t contains these elements;
        // if all contains, return true; else, return false;
        
        // Time and space complexity is O(n); 
        
        // the problem is, we have to count how many times each letter appears;
        // so we can't use hashset. We have to use hashmap.put(charAt(i),count);
        // solution1: put them into 2 hashmap, and see if they contains same elements;
        // solution2: put s into 1 hashmap, and compare with t;
        // Time and space complexity is O(n); 
        
        
        /* following is my 1 correct approach:
        //Time and space complexity is O(n); 
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        
        // put elements of s into hashmap;
        for(int i = 0; i < s.length(); i++){
            int currentCount1 = map1.getOrDefault(s.charAt(i),0) + 1;
            int currentCount2 = map2.getOrDefault(t.charAt(i),0) + 1;
            map1.put(s.charAt(i), currentCount1);
            map2.put(t.charAt(i), currentCount2);
        }
        // see if they're equal;
        return map1.equals(map2);
        */
        
        
        /* this is a second correct approach, using sorting:
        // first we need to turn string into array, then using sort();
        // time complexity is O(nlogn); space complexity is O(n) cause we create 2 arrays;
        char[] array1 = s.toCharArray();
        char[] array2 = t.toCharArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        // !!!we can't use array1.equals(array2), cause it's for comparing the reference content. We have to use Array.sort(a,b);
        return Arrays.equals(array1, array2);
        */
        
        // this is the 3rd approach, using array to store the values and counts
        /*
        int[] count = new int[26];
        for(char a1: s.toCharArray()){
            count[a1 - 'a'] ++;
        }
        for(char a2: t.toCharArray()){
            count[a2 - 'a'] --;
        }
        for(int i : count){
            if(i != 0){
                return false;
            }
        }
        return true;
        */
    }
}