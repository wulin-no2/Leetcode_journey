class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        # use a list to store result
        result = []
        # 3 conditions when traversing
        # 1. interval[1] < newInterval[0], add interval
        # 2. interval[0] > newInterval[1], add newInterval, update newInterval
        # 3. merge it
        for interval in intervals:
            if interval[1] < newInterval[0]:
                result.append(interval)
            elif interval[0] > newInterval[1]:
                result.append(newInterval)
                newInterval = interval
            else:
                newInterval[0] = min(interval[0], newInterval[0])
                newInterval[1] = max(interval[1], newInterval[1])
        result.append(newInterval)
        return result