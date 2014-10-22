package cn.erhu.leetcode;

/**
 * Given a binary tree, find its maximum depth.
 * <p/>
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * <p/>
 * User: hujunjie
 * Date: 14-10-22
 * Time: 下午6:43
 */
public class MaxDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left_depth = maxDepth(root.left);
        int right_depth = maxDepth(root.right);
        return left_depth > right_depth ? left_depth + 1 : right_depth + 1;
    }
}
