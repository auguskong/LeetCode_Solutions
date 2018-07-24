/*
* bug free 07.23
* 基本思路： bottom -> up 结构，先递归调用，默认剪枝完成，然后接真正的剪枝操作
* 剪枝的条件： 叶节点 + root.val == 0
*/

class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        //什么条件下进行剪枝操作？
        if (root.left == null && root.right == null & root.val == 0) {
            return null;
        }
        return root;
    }
}