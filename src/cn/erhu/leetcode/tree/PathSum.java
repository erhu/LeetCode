package cn.erhu.leetcode.tree;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals the given sum.
 * <p/>
 * For example:
 * Given the below binary tree and sum = 22,
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 *
 * @author hujunjie
 * @version 1.0
 * @since 15-3-9 下午2:20
 */
public class PathSum {
    /*
    *       5
    *      / \
    *     4   8
    *    /   / \
    *   11  13  4
    *  /  \      \
    * 7    2      1
    * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
    */

    /**
     * 一边遍历, 一边作差, 直到某个叶子结点,且差为0时,找到匹配的路径
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        // 差为0, 叶子结点
        if (sum - root.val == 0 && root.left == null && root.right == null) {
            return true;
        }

        // 检查左树/右树
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}

