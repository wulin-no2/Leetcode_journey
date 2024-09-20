class Solution:
    def longestPalindrome(self, s: str) -> int:
        arr = [0] * 128
        # traverse string
        for c in s:
            arr[ord(c)] += 1
        # count
        count = 0
        hasOdd = 0
        for i in arr:
            if i % 2 == 0:
                count += i 
            else:
                count += i-1
                hasOdd = 1
        return count + hasOdd
        
        