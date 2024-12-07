class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        path = []
        def backtrack(startIndex):
            res.append(list(path))
            for i in range(startIndex, len(nums)):
                path.append(nums[i])
                backtrack(i+1)
                path.pop()
        backtrack(0)
        return res
        