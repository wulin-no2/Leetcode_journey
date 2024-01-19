class Solution {
    public String minWindow(String s, String t) {
        // sliding window:
        HashMap<Character, Integer> map = new HashMap<>();
        // get map for t;
        for (char x : t.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int matched = 0;
        int start = 0;
        int minLen = s.length() + 1;
        int subStr = 0;
        // traverse until end of s;
        for (int endWindow = 0; endWindow < s.length(); endWindow++) {
            // right is letter of the end pointer
            char right = s.charAt(endWindow);
            if (map.containsKey(right)) {
                map.put(right, map.get(right) - 1);
                if (map.get(right) == 0) matched++;// matched 1 more letter;
            }

            while (matched == map.size()) { // find the window. move start
                // update len, subStr
                if (minLen > endWindow - start + 1) {
                    minLen = endWindow - start + 1;
                    subStr = start;
                }
                // update start via deleting letters from start
                // deleted is letter at start;
                char deleted = s.charAt(start++);//keep moving start, until find valid letter;
                if (map.containsKey(deleted)) {
                    if (map.get(deleted) == 0) matched--;// move out 1 and continue moving end;
                    map.put(deleted, map.get(deleted) + 1);// 1 means missing it in the window; 0 means the letter matched; -1 means window contains > 1 letter;
                }
            }
        }
        return minLen > s.length() ? "" : s.substring(subStr, subStr + minLen);
        
    }
}