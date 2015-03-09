package cn.erhu.leetcode.test;

import cn.erhu.leetcode.tree.PathSum;
import cn.erhu.leetcode.tree.TreeNode;
import org.junit.Test;

/**
 * #本文件的功能说明#
 *
 * @author hujunjie
 * @version 1.0
 * @since 15-3-9 下午2:49
 */
public class PathSumTest {
    @Test
    public void test() {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(4);
        node.right = new TreeNode(1);

        node.left.left = new TreeNode(6);
        node.left.right = new TreeNode(1);
        node.left.right.left = new TreeNode(1);

        node.left.left.left = new TreeNode(1);
        node.left.left.right = new TreeNode(1);

        System.out.print(new PathSum().hasPathSum(node, 12));
    }
}
