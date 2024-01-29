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
        
        
        
        
        // find elements from collection
        // order is not important
        // can be repeated
        // we can use LinkedList or HashMap
        // first, we use LinkedList to store elements in magazine
        // and compare with elements in ransomNote
        // if we can find it, delete it; or we return false
        // until the elements in ransomNote are running out, return true
        
        /*contains() and remove() operations, which are both O(n) for a LinkedList. When combine these operations in a loop, the overall time complexity becomes O(n*m). So we'd better use HashMap here.
        
        LinkedList<Character> list = new LinkedList<>();
        // add magazine:
        for(char m : magazine.toCharArray()){
            list.add(m);
        }
        // compare:
        for(char r : ransomNote.toCharArray()){
            if(list.contains(r)){
                list.remove(r);
            }else{
                return false;
            }
        }
        return true;
        */
        // time complexity : O(m + r) = O(n)
        // space complexity: O(n)
        /*
        HashMap<Character, Integer> hashmap = new HashMap<>();
        // add magazine;
        for(char m : magazine.toCharArray()){
            hashmap.put(m, hashmap.getOrDefault(m, 0) + 1);
        }
        // compare and remove;
        for(char r : ransomNote.toCharArray()){
            if(!hashmap.containsKey(r)){
                return false;
            }
            hashmap.put(r, hashmap.get(r) - 1);
            if(hashmap.get(r) < 0){
                return false;
            }
        }
        return true;
        */
        
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