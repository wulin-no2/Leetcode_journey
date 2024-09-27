class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        max_sum = nums[0]
        sum_until_now = 0
        for num in nums:
            sum_until_now += num
            if sum_until_now > max_sum:
                max_sum = sum_until_now 
            if sum_until_now < 0:
                sum_until_now = 0
        return max_sum
        