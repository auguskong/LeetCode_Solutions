/**
* Descirption: find the number of paths that sum to a given value
*
* 
*/

class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return findPathFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    private int findPathFrom (TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        //包含root.val
        if (root.val == sum) {
            return findPathFrom(root.left, sum - root.val) + findPathFrom(root.right, sum - root.val) + 1;
        }
        
        //不包含root.val
        return findPathFrom(root.left, sum - root.val) + findPathFrom(root.right, sum - root.val);
    }
}