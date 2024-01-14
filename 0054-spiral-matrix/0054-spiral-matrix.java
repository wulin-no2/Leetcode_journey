class Solution {
    // int[][] visited;
    public List<Integer> spiralOrder(int[][] matrix) {
        /*
        // almost right, but not :(
        // analyze:
        // new ArrayList res;
        // new int[m][n] visited;
        // right,down,left,up, for each direction, until visited || inValid, then change direction;
        // o(n)
        // if int[i][j] valid, res.add, see if 4 directions valid;
        // if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
        //     return new ArrayList<>();
        // }
        visited = new int[matrix.length][matrix[0].length];
        List<Integer> list = new ArrayList<>();
        list.add(matrix[0][0]);
        visited[0][0] = 1;
        int p = 0;
        int q = 0;
        int[] temp;
        while(true){
            temp = nextPos(matrix, p, q);
            if (temp[0] == -1) break;
            p = temp[0];
            q = temp[1];
            list.add(matrix[p][q]);
            visited[p][q] = 1;
        }
        return list;
        
    }
    private boolean isValid(int[][] matrix, int i, int j){
        return visited[i][j] == 0 && i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length;
    }
    private int[] nextPos(int[][] matrix, int i, int j){
        // int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        // if(isValid(matrix, i + 1, j)) return new int[]{i + 1, j};
        // if(isValid(matrix, i, j + 1)) return new int[]{i, j + 1};
        // if(isValid(matrix, i - 1, j)) return new int[]{i - 1, j};
        //if(isValid(matrix, i, j - 1)) return new int[]{i, j - 1};
        // return new int[]{-1, -1};
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int[] dir : dirs) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            if (isValid(matrix, newI, newJ)) {
                return new int[] {newI, newJ};
            }
        }
        return new int[] {-1, -1};
        */
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        
        int rows = matrix.length, cols = matrix[0].length;
        int left = 0, right = cols-1, top = 0, bottom = rows-1;
        
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;
            
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
            
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
        

    }
}