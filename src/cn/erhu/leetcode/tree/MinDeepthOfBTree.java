package cn.erhu.leetcode.tree;

/**
 * Given a binary tree, find its minimum depth.
 * <p/>
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * @author hujunjie
 * @version 1.0
 * @since 15-3-9 上午10:33
 */
public class MinDeepthOfBTree {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        // 左右子树都不为空
        if (root.left != null && root.right != null) {
            int left_min, right_min;
            left_min = minDepth(root.left);
            right_min = minDepth(root.right);
            return (left_min < right_min ? left_min : right_min) + 1;

        }
        // 左树不为空
        if (root.left != null) {
            return minDepth(root.left) + 1;
        }
        // 右树不为空
        return minDepth(root.right) + 1;
    }
}
