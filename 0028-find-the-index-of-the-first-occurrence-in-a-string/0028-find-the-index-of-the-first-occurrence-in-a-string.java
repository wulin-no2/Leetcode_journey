class Solution {
    // from discuss:
    public int strStr(String haystack, String needle) {
        // use array to handle them;
        if(needle.length() > haystack.length()) return -1;
        char[] hay = haystack.toCharArray();
        char[] need = needle.toCharArray();
        
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
              if (j == need.length) return i;
              if (i + j == hay.length) return -1;
              if (need[j] != hay[i + j]) break;
            }
        }
}
    
    /* from camp:
    //前缀表（不减一）Java实现
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int[] next = new int[needle.length()];
        getNext(next, needle);

        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && needle.charAt(j) != haystack.charAt(i)) 
                j = next[j - 1];
            if (needle.charAt(j) == haystack.charAt(i)) 
                j++;
            if (j == needle.length()) 
                return i - needle.length() + 1;
        }
        return -1;

    }
    
    private void getNext(int[] next, String s) {
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(j) != s.charAt(i)) 
                j = next[j - 1];
            if (s.charAt(j) == s.charAt(i)) 
                j++;
            next[i] = j; 
        }
    }
    */
    /* my own solution - brute force:
    public int strStr(String haystack, String needle) {
        // find first char of needle, then find second..
        // use array to handle them;
        if(needle.length() > haystack.length()) return -1;
        char[] hay = haystack.toCharArray();
        char[] need = needle.toCharArray();
        // 1. find first char;
        // 2. find sencond char;
        // ...loop entil the end;
        int i = 0; // hay pointer;
        int temp = 0; // index of the start;
        while(i < hay.length){
            int j = 0; // need pointer;
            // find first;
            if(hay[i] != need[j]) i++;
            // if ==, record the index;
            else{
                temp = i;
                // see if following letters are the same;
                while(j < need.length && i < hay.length){
                    if(hay[i] == need[j]) {
                        if(j == need.length - 1) return temp;
                        i++;
                        j++;
                    }
                    else if(hay[i] != need[j]) {
                        i = temp + 1; 
                        break;
                    }
                }
            }  
        }
        return -1;
    }
    */
}