class Solution {
    public boolean checkValidString(String s) {
        int low = 0, high = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                low++;
                high++;
            } else if (c == ')') {
                low--;
                high--;
            } else { // '*'
                low--;  // Treat '*' as ')'
                high++; // Treat '*' as '('
            }

            if (high < 0) return false; // Too many ')'
            if (low < 0) low = 0; // Reset since '*' can be empty
        }

        return low == 0; 
    }
}