class Solution {
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
}