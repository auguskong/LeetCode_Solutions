/**
*
* Date: 06/13/18
* 
*/

class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int res = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    Search(grid, i, j);
                    res++;
                }
            }
        }
        
        return res;
    }
    
    private boolean inBound(char[][] grid, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        return i >= 0 && i < rows && j >= 0 && j < cols;
    }
    
    private void Search(char[][] grid, int i, int j) {
        if (!inBound(grid, i, j)) {
            return;
        }
        
        if (grid[i][j] == '0') {
            return;
        }
        
        grid[i][j] = '0';
        Search(grid, i + 1, j);
        Search(grid, i - 1, j);
        Search(grid, i, j + 1);
        Search(grid, i, j - 1);
    }
}