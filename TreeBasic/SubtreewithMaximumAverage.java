// find the subtree with maximum average value

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: the root of the maximum average of subtree
     */
     
    private class Result {
        private int sum;
        private int size;
        private TreeNode node;
        public Result(int sum, int size, TreeNode node) {
            this.sum = sum;
            this.size = size;
            this.node = node;
        }
    }
    
    private Result currMax = null;
    
    public TreeNode findSubtree2(TreeNode root) {
        // write your code here
        if (root == null) {
            return null;
        }
        helper(root);
        return currMax.node;
    }
    
    private Result helper(TreeNode node) {
        if (node == null) {
            return new Result(0,0,null);
        }
        Result left = helper(node.left);
        Result right = helper(node.right);
        Result res = new Result(
            left.sum + right.sum + node.val,
            left.size + right.size + 1,
            node);
        if (currMax == null || res.sum * currMax.size > res.size * currMax.sum) {
            currMax = res;
        }
        return res;
    }
}