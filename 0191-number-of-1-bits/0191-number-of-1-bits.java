class Solution {
    public int hammingWeight(int n) {
        //  int count = 0;
        // while (n != 0) {
        //     count += (n & 1); // Add 1 if the last bit is 1
        //     n >>>= 1;        // Unsigned right shift
        // }
        // return count;
        int count = 0;
        while (n != 0) {
            n &= (n - 1); // Remove the rightmost 1
            count++;
        }
        return count;
        
    }
}