class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
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
        
        
        
        
        
    }
}