class Solution {
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
}