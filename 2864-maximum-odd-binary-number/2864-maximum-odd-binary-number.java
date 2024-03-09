class Solution {
    public String maximumOddBinaryNumber(String s) {
        /*
        // the last digit must be 1 since it's odd;
        // then make remaining 1s as left as possible;
        // 2 pointers;
        char[] chars = s.toCharArray();
        int p = 0, q = chars.length - 1;
        while(p <= q){
            if(chars[p]=='1') p++; // find 0 for p;
            if(chars[q]=='0') q--; // find 1 for q;  
            if(p <= q && chars[p] == '0' && chars[q] == '1'){// swap s.charAt(q) with s.charAt(p);
                chars[q] = '0';
                chars[p] = '1';
            }
        }
        // Swap rightmost 1 bit to the end
        chars[p - 1] = '0';
        chars[chars.length - 1] = '1';
        return new String(chars);
        */
        char[] arr = s.toCharArray();
        int N = arr.length;
        
        Arrays.sort(arr);

        // Reverse order for the first N - 1 elements of the array
        // Because we want to keep a 1 at the last index
        // The last element of the array is index N - 1, and the second to last element is at N - 2
        int secondLast = N - 2;
        for (int i = 0; i < N / 2; i++) {
            char temp = arr[i];
            arr[i] = arr[secondLast - i];
            arr[secondLast - i] = temp;
        }

        // Return result
        return new String(arr);
    }
}