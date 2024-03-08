class Solution {
    public int integerBreak(int n) {
        // 2 = 1 * 1
        // 3 = 1 * 2
        // 4 = 2 * 2
        // 5 = 2 * 3 -- 
        // 6 = 3 * 3
        // 7 = 3 * 4
        // 8 = 2 * 3 * 3
        // 9 = 3 * 3 * 3
        // 10 = 3 * 3 * 4
        // 11 = 3 * 3 * 3 * 2
        // basically, we only need multile 3s, then one 2 or one 4
        if(n < 4) return n - 1;
        int exp = n / 3;
        int remain = n % 3;
        if(remain == 2) return (int)Math.pow(3, exp) * 2;
        else if(remain == 1) return (int)Math.pow(3, exp - 1) * 4;
        else return (int)Math.pow(3, exp);
        
    }
}