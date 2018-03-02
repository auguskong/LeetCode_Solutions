//Combination of Diameter of a tree + another equality check 

class Solution {
    int len = 0; // global variable
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        len = 0;
        getLen(root, root.val);
        return len;
    }

    private int getLen(TreeNode node, int val) {
        if (node == null) return 0;
        int left = getLen(node.left, node.val);
        int right = getLen(node.right, node.val);
        len = Math.max(len, left + right);
        if (val == node.val)  return Math.max(left, right) + 1;
        return 0;
    }
}

//Code for Diameter of Binary Tree Question
class Solution {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxDepth(root);
        return max;
    }
    
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        int maxDepth = Math.max(left, right);
        max = Math.max(max, left + right);
        
        return maxDepth + 1;
    }
}