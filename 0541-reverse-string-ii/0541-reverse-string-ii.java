class Solution {
    // the most important thing is, string is immutable in Java;
    public String reverseStr(String s, int k) {
        // for every 2k elements, reverse first k elements;
        // if the remaining < k, reverse all remaining;
        // if the remaining >= k && < 2k, reverse first k elements;
        char[] arr = s.toCharArray();
        for(int i = 0 ; i < s.length() ; i += 2*k){
            if(s.length() - i < k) reverseArr(arr, i , s.length() - 1);
            else reverseArr(arr, i , i + k - 1);
        }
        return new String(arr);
    }
    private void reverseArr(char[] arr, int left, int right){
        //2 pointers, including left and right;
        while(left < right){
            char temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;
            left++;
            right--;
        }
    }
}