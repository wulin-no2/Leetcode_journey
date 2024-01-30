class Solution {
    public String reverseWords(String s) { 
        // 2. convert to array, reverse all the array;
        char[] arr = s.toCharArray();
        reverseArr(arr, 0, arr.length - 1);
        
        // 3. remove space and reverse and move to right position with 2 pointers;
        int slow = 0;
        int fast = 0;
        while(fast < arr.length){
            // remove space until end or until there are characters;
            while(fast < arr.length && arr[fast] == ' ') fast++;
            // if all the remaining is space, break;
            if (fast >= arr.length) break; 
            // add space before other characters;
            if (slow > 0) arr[slow++] = ' '; 
            // record the begining of the word; 
            int left = slow;
            // move words;
            while(fast < arr.length && arr[fast] != ' '){
                arr[slow++] = arr[fast++];
            }
            // reverse the word;
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