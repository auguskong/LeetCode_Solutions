/**
* 最值型DP
* Point: 状态为currMax 
* Follow up: Maximum Product Subarray 
* 需要用变量保存 currMax currMin两个值，因为会有负数相乘的情况
*/

class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //状态为: 当前位置的最大值
        //转移方程为： Math.max(f[i - 1] + nums[i], nums[i])
        int n = nums.length;
        int[] f = new int[n];
        f[0] = nums[0];
        int max = f[0];
        for (int i = 1; i < n; i++) {
            f[i] = Math.max(f[i - 1] + nums[i], nums[i]);
            max = Math.max(f[i], max);
        }
        return max;
    }
}