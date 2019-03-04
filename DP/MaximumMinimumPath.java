/*
给一个矩阵,

先找所有从左上到右下的path.
找出每个path的最小值.
找出这些最小值中的最大值.
*/
public class Solution {
	public static int maximumMinimumPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];                                // dp[i,j]路径中最小值 (不过下边有所不同)
        dp[0][0] = matrix[0][0];// [0,0] 肯定在考虑点中
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i - 1][0], matrix[i][0]); 
        }
        for (int i = 1; i < m; i++) {
            dp[0][i] = Math.min(dp[0][i - 1], matrix[0][i]);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.min(Math.max(dp[i - 1][j], dp[i][j - 1]),// 每次选点的时候,因为路径只可能是从上或者从左, 所以选其中较大的, 再去合当前值比较.即可
                        matrix[i][j]);
            }
        }
        return dp[n - 1][m - 1];
    }
 
    public static void main(String[] args) {
        int[][] d = new int[][]{
                {8,4,3,5},
                {6,5,9,8},
                {7,2,3,6}
        } ;
        System.out.println(maximumMinimumPath(d)); // 5
    }
}