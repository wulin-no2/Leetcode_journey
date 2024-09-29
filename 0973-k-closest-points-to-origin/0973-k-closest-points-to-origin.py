class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        # use max_heap to store points
        # use negative distance to simulate max_heap
        max_heap = [] # create list as heap
        for point in points:
            distance = -(point[0]*point[0] + point[1]*point[1]) 
            if len(max_heap) < k:
                heapq.heappush(max_heap, (distance,point))
            else:
                heapq.heappushpop(max_heap, (distance,point))
        return [point for (_, point) in max_heap]
        