class Solution {
    public String reverseWords(String s) { 
        // 2. convert to array, reverse all the array;
        char[] arr = s.toCharArray();
        reverseArr(arr, 0, arr.length - 1);
        
        // 3. remove space and reverse and move to right position with 2 pointers;
        int slow = 0;
        int fast = 0;
        while(fast < arr.length){
            // 3.1 remove space and move to right position;
            // remove first space;
            while(fast < arr.length && arr[fast] == ' ') fast++;
            if (fast >= arr.length) break; 
            // add space;
            if (slow > 0) arr[slow++] = ' '; 
             
            int left = slow;
            // System.out.println("fast is: " + fast + " slow is: " + slow + " left is: " + left);
            // move words;
            while(fast < arr.length && arr[fast] != ' '){
                arr[slow] = arr[fast];
                fast++;
                slow++;
                // System.out.println("while fast is: " + fast + " slow is: " + slow);
            }
            // System.out.println("fast is: " + fast + " slow is: " + slow + " left is: " + left + " right is: " + right);
            
            // 3.2 reverse arr;
            reverseArr(arr, left, slow - 1);
        }
        // 4. convert to String;
        return new String(arr, 0, slow);
    }
    
    // 1.write a reverse method;
    private void reverseArr(char[] arr, int left, int right){
        while(left < right){
            char temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;
            left++;
            right--;
        }
    }
}