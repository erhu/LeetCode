package cn.erhu.leetcode.test;

import cn.erhu.leetcode.tree.MaxDepthOfBinaryTree;
import cn.erhu.leetcode.tree.TreeNode;
import org.junit.Test;

/**
 * #本文件的功能说明#
 * <p/>
 * User: hujunjie
 * Date: 14-10-22
 * Time: 下午6:49
 */
public class MaxDepthOfBinaryTreeTest {
    @Test
    public void test() {
        TreeNode node = new TreeNode(0);
        TreeNode node_1 = new TreeNode(1);
        TreeNode node_2 = new TreeNode(1);
        node.left = node_1;
        node.right = node_2;

        TreeNode node_3 = new TreeNode(3);
        TreeNode node_4 = new TreeNode(4);
        node_1.left = node_3;
        node_1.right = node_4;


        TreeNode node_5 = new TreeNode(5);
        TreeNode node_6 = new TreeNode(6);
        node_2.left = node_5;
        node_2.right = node_6;

        TreeNode node_7 = new TreeNode(7);
        TreeNode node_8 = new TreeNode(8);
        node_3.left = node_7;
        node_4.right = node_8;

        /*TreeNode node_9 = new TreeNode(9);
        TreeNode node_10 = new TreeNode(10);
        node_5.left = node_9;
        node_6.right = node_10;*/

        MaxDepthOfBinaryTree mdb = new MaxDepthOfBinaryTree();
        org.junit.Assert.assertEquals(mdb.maxDepth(node), 4);
    }
}
