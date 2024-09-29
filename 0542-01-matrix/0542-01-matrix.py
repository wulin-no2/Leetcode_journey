class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        # BFS
        m = len(mat)
        n = len(mat[0])
        result = [[float('inf')] * n for _ in range(m)]  # Initialize result matrix with infinity
        
        queue = deque()
        
        # initialize result and queue
        for i in range (m):
            for j in range (n):
                if mat[i][j]==0:
                    result[i][j]=0
                    queue.append((i,j))
        
        # helper list
        directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]
        # BFS
        while queue:
            # get en element
            x, y = queue.popleft() 
            # update 4 directions
            for dx, dy in directions:
                newX, newY = x + dx, y + dy
                # check validation
                if 0 <= newX < m and 0 <= newY < n:
                    if result[newX][newY] > result[x][y] + 1:
                        result[newX][newY] = result[x][y] + 1
                        queue.append((newX, newY))
                        
        return result
        