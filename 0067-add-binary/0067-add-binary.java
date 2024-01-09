class Solution {
    public String addBinary(String a, String b) {
        // there are some methods we can use:
        // first, transfer a String with number into decimal:
        /*
        int aInt = Integer.parseInt(a, 2);
        int bInt = Integer.parseInt(b, 2);
        int num = aInt + bInt; 
        // second, transfer a number of decimal in to binary;
        return Integer.toBinaryString(num);
        */
        
        // the problem is. a and b are too long.
        // we can't simply tranfer them to int, or they will surpass the constraint of the boundary of int
        // we can use BigInteger
        /*
        return new java.math.BigInteger(a, 2).add(new java.math.BigInteger(b, 2)).toString(2);
        */
        String result = "";
        int carry = 0;
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            carry = sum / 2;
            result = (sum % 2) + result;
        }
        return result;
    }
}