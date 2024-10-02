class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        res = 0
        # sliding window to track the left and the right of the non-repeating substring
        left = 0
        length = len(s)
        # Use a dictionary to store the most recent index of each character
        arr = {}
        for i in range(length):
            c = s[i]
            if c in arr  and arr[c] >= left:  # c exist, update res, update left, update arr[c]
                left = arr[c] + 1
            arr[c] = i
            res = max(res, i - left + 1)
        return res
                
                
            