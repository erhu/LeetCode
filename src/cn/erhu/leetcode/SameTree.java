package cn.erhu.leetcode;

/**
 * 判断两棵二叉树是否相等
 * <p/>
 * User: hujunjie
 * Date: 14-10-16
 * Time: 下午5:17
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 两树都为空
        if (p == null && q == null) {
            return true;
        }
        // 其中一棵树为空
        else if (p == null || q == null) {
            return false;
        }

        return p.val == q.val
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        this.val = x;
    }
}
