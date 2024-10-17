class Solution {
    public boolean isValidSudoku(char[][] board) {
    // 使用布尔数组来跟踪数字是否已存在
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] cubes = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1'; // 将字符 '1'-'9' 转换为索引 0-8

                    // 检查行
                    if (rows[i][num]) {
                        return false;
                    }
                    rows[i][num] = true;

                    // 检查列
                    if (cols[j][num]) {
                        return false;
                    }
                    cols[j][num] = true;

                    // 检查3x3的子盒子
                    int cubeIndex = (i / 3) * 3 + j / 3;
                    if (cubes[cubeIndex][num]) {
                        return false;
                    }
                    cubes[cubeIndex][num] = true;
                }
            }
        }

        return true;
    }
    /*
    public boolean isValidSudoku(char[][] board) {
        
        return isValidRow(board) && isValidColumn(board) && isValidCube(board);
        
    }
    public boolean isValidColumn(char[][] board){
        int length = board.length;
        for(int j = 0; j < length; j++){
            // check valid column;
            HashSet<Character> set = new  HashSet<>();
            for(int i = 0; i < length ; i++){
                if(board[i][j]!='.' && set.contains(board[i][j])) return false;
                set.add(board[i][j]); 
            }
        }
        return true;
    }
    public boolean isValidRow(char[][] board){
        int length = board.length;
        for(int i = 0; i < length; i++){
            // check valid row;
            HashSet<Character> set = new  HashSet<>();
            for(int j = 0; j < length ; j++){
                if(board[i][j]!='.' && set.contains(board[i][j])) return false;
                set.add(board[i][j]); 
            }
        }
        return true;
    }
    public boolean isValidCube(char[][] board){
        int length = board.length;
        for(int i = 0; i < length; i+=3){
            for(int j = 0; j < length; j+=3){
                // check valid cube;
                HashSet<Character> set = new  HashSet<>();
                for(int m = i;m <= i+2; m++){
                    for(int n = j;n <= j+2; n++){
                         if(board[m][n]!='.' && set.contains(board[m][n])) return false;
                         set.add(board[m][n]); 
                    }
                }
            }
        }
        return true;

    }
    */
}