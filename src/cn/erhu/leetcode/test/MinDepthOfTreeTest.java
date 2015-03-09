package cn.erhu.leetcode.test;

import cn.erhu.leetcode.tree.MinDeepthOfBTree;
import cn.erhu.leetcode.tree.TreeNode;
import org.junit.Test;

/**
 * #本文件的功能说明#
 *
 * @author hujunjie
 * @version 1.0
 * @since 15-3-9 下午1:51
 */
public class MinDepthOfTreeTest {

    @Test
    public void test() {
        TreeNode node = new TreeNode(45);
        TreeNode node_1 = new TreeNode(1);
        TreeNode node_2 = new TreeNode(1);
        node.left = node_1;
        node.left = node_2;

        TreeNode node_3 = new TreeNode(2);
        TreeNode node_4 = new TreeNode(3);
        node_1.left = node_3;
        node_1.right = node_4;


        TreeNode node_5 = new TreeNode(3);
        TreeNode node_6 = new TreeNode(2);
        node_2.left = node_5;
        node_2.right = node_6;

        TreeNode node_7 = new TreeNode(4);
        TreeNode node_8 = new TreeNode(5);
        node_3.left = node_7;
        node_4.right = node_8;

        System.out.println(new MinDeepthOfBTree().minDepth(node));
    }
}
