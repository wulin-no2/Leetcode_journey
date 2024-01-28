class Solution {
    /* my solution using string to get digit:
    public boolean isHappy(int n) {
        // use a set to store each result. if it's contained in set, return false; if it's 1, return true;
        HashSet<Integer> set = new HashSet<>();
        // transfer digit to char to calculate;
        String num = n + "";
        while(true){
            // store each result;
            int temp = 0;
            for(int i = 0; i < num.length(); i ++){
                int ele = num.charAt(i) - '0';
                temp += ele * ele;
                // System.out.println("temp: " + temp);
            }
            if(temp == 1) return true;
            if(set.contains(temp)) return false;
            set.add(temp);
            num = temp + "";
            // System.out.println("set: " + set);
        }
    }
    */
    // solution from camp:
    public boolean isHappy(int n) {
        Set<Integer> record = new HashSet<>();
        while (n != 1 && !record.contains(n)) {
            record.add(n);
            n = getNextNumber(n);
        }
        return n == 1;
    }

    private int getNextNumber(int n) {
        int res = 0;
        while (n > 0) {
            int temp = n % 10;
            res += temp * temp;
            n = n / 10;
        }
        return res;
    }
}