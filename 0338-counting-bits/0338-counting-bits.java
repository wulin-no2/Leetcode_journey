// class Solution {
//     public int[] countBits(int n) {
//         int[] ans = new int[n + 1];
//         for (int i = 0; i <= n; i++) {
//             ans[i] = countOnes(i);
//         }
//         return ans;
//     }
    
//     private int countOnes(int num) {
//         int count = 0;
//         while (num > 0) {
//             count += (num & 1); // Check the last bit
//             num >>= 1;         // Shift right by 1
//         }
//         return count;
//     }
// }

public class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1); // DP relation
        }
        return ans;
    }
}
