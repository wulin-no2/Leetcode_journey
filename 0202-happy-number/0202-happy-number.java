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
    // solution from camp using set:
    /*
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
    */
    // solution from discuss using 2 pointers. just see it as cycled linkedlist;
    public boolean isHappy(int n) {
        
        int slow = n;
        int fast = n;
//while loop is not used here because initially slow and 
//fast pointer will be equal only, so the loop won't run.
        do {
//slow moving one step ahead and fast moving two steps ahead

            slow = square(slow);
            fast = square(square(fast));
        } while (slow != fast);

//if a cycle exists, then the number is not a happy number
//and slow will have a value other than 1

        return slow == 1;
    }
    
//Finding the square of the digits of a number

    public int square(int num) {
        
        int ans = 0;
        
        while(num > 0) {
            int remainder = num % 10;
            ans += remainder * remainder;
            num /= 10;
        }
        
        return ans;
    }
}