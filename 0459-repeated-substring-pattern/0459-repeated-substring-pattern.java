class Solution {
    public boolean repeatedSubstringPattern(String s) {
        ///*
        for (int i = 1; i <= s.length() / 2; i++) {
            if (s.length() % i == 0) {
                String substring = s.substring(0, i);
                StringBuilder temp = new StringBuilder();
                for (int j = 0; j < s.length() / i; j++) {
                    temp.append(substring);
                }
                if (temp.toString().equals(s)) {
                    return true;
                }
            }
        }
        return false;
        //*/
        /* my own solution: slooooooow;
        // convert to StringBuilder;
        // StringBuilder sb = new StringBuilder(s);
        // find the nth same letter with first letter; use subArray to see if it's work;
        for(int i = 1 ; i <= s.length() / 2; i++){
            String sub = s.substring(0, i);
            StringBuilder temp = new StringBuilder();
            while (temp.length() < s.length()){
                temp.append(sub);
            }
            if(temp.toString().equals(s)) return true;
        }
        return false;  
        */
    }
}