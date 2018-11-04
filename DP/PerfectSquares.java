/**
* Date: 11/02/2018
* Type: DP
* 数据结构: 一维数组
* 错点: 求最小值时初始化应为 最大MAX_VALUE
*
*/

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            // 初始化的j 应该是1, 也必须是1,
            // 否则会有dp[1] + 1 -> 2147483647 + 1 = -2147483648 整数溢出的问题
            int j = 1;
            //状态转移是按照平方数来转移的 i - j * j
            while (i - j * j >= 0) {
                min = Math.min(min, dp[i - j * j] + 1);
                ++j;
            }
            dp[i] = min;
        }
        return dp[n];
    }
}