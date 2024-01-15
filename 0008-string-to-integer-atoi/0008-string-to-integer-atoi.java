import java.math.BigInteger;
class Solution {
    public int myAtoi(String s) {
        // following the instructions
        StringBuilder sNew = new StringBuilder();
        // boolean isNeg = false;

        for(char i : s.toCharArray()){
            // 1) ingnore the whitespace 2) decide if it's negative;
            if((i==' ') && sNew.length() == 0) continue;
            if((i=='+' || i=='-') && sNew.length() == 0) {sNew.append(i); continue;}
            // read until end or non digit;
            if(i >= '0' && i <= '9') sNew.append(i);
            else break;
        }
        if(sNew.length() == 0 || (sNew.length() == 1 && (sNew.charAt(0) == '+' || sNew.charAt(0) == '-')))
            return 0;
        BigInteger big;
        try{
            big = new BigInteger(sNew.toString());
        }catch(NumberFormatException e){
            if(sNew.charAt(0)=='-') return Integer.MIN_VALUE;
            else return Integer.MAX_VALUE;
        }
        //if(isNeg) big = big.negate();
        if(big.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0) return Integer.MIN_VALUE;
        if(big.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) return Integer.MAX_VALUE;
        return big.intValue();
    }
}