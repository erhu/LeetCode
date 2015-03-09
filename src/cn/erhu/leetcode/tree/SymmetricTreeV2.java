package cn.erhu.leetcode.tree;

/**
 * SymmetricTree
 * <p/>
 * User: hujunjie
 * Date: 14-10-17
 * Time: 下午3:26
 */
public class SymmetricTreeV2 {
    public boolean isSymmetric(TreeNode root) {
        return root == null || travel(root.left, root.right);
    }

    public boolean travel(TreeNode left, TreeNode right) {
        // 两棵树均为空 ＝> true
        if (left == null && right == null) {
            return true;
        }

        // 只有一颗树为空 => false
        if (left == null || right == null) {
            return false;
        }

        return left.val == right.val// 值相等
                // 比较对称的节点的值是否相等
                && travel(left.left, right.right)// 比较左树的左节点和右树的右节点是否相等
                && travel(left.right, right.left);// 比较左树的右节点和右树的左节点是否相等
    }
}
