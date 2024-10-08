class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # use set to store elements
        setForStore = set()
        # use left & i to create a sliding window
        left = 0
        res = 0
        for i in range(len(s)):
            while s[i] in setForStore:
                setForStore.remove(s[left])
                left+=1
            setForStore.add(s[i])
            res = max(res, i - left + 1)
        return res
        