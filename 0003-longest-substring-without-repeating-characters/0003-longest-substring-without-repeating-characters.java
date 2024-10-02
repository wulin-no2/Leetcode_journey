// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         // array hashing, record last seen index for each character
//         int[] arr = new int[128];
//         int res = 0;
//         // use sliding window to track unique substring
//         int left = 0;
//         // traverse s
//         for(int i = 0; i < s.length(); i++){
//             char c = s.charAt(i);
//             // if s.charAt(i) in arr, update its index, move left, update res
//             if(arr[c] > 0 && arr[c] >= left) left = arr[c];
//             res = Math.max(res,i - left + 1);
//             arr[c] = i + 1; 
//         }
//         // return max(res, count)
//         return res;
//     }
// }
import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // HashMap to store the last seen index of each character
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0;
        int left = 0;  // The left boundary of the sliding window
        
        // Traverse the string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // If the character has been seen and is within the current window
            if (map.containsKey(c) && map.get(c) >= left) {
                left = map.get(c) + 1;  // Move the left boundary to one position after the last occurrence of c
            }
            
            // Calculate the length of the current substring and update the result
            res = Math.max(res, i - left + 1);
            
            // Update the last seen index of the character
            map.put(c, i);
        }
        
        return res;
    }
}
