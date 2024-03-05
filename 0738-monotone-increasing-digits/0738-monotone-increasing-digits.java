class Solution {
    public int monotoneIncreasingDigits(int n) {
        // the rule is, if we need to borrow 1 from this digit, then the following digits after that should all be 9; it should decrease 1;
        if(n < 10) return n;
        String s = n + "";
        char[] chars = s.toCharArray();
        for(int i = chars.length - 1; i >= 1 ; i--){
            if(chars[i - 1] > chars[i]) {
                chars[i - 1]--;
                // set all the digit after be 9;
                for (int j = i; j < chars.length; j++) {
                    chars[j] = '9';
                }
            }
        }
        return Integer.parseInt(new String(chars));
    }
}