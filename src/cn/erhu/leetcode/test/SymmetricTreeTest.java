package cn.erhu.leetcode.test;

import cn.erhu.leetcode.SymmetricTreeV1;
import cn.erhu.leetcode.SymmetricTreeV2;
import cn.erhu.leetcode.TreeNode;
import org.junit.Test;

/**
 * #本文件的功能说明#
 * <p/>
 * User: hujunjie
 * Date: 14-10-17
 * Time: 下午3:37
 */
public class SymmetricTreeTest {

    @Test
    public void nullTest() {
        TreeNode node = new TreeNode(0);
        SymmetricTreeV1 st = new SymmetricTreeV1();
        org.junit.Assert.assertEquals(st.isSymmetric(node), true);
    }

    @Test
    public void symmetricTest() {
        TreeNode node = new TreeNode(45);
        TreeNode node_1 = new TreeNode(1);
        TreeNode node_2 = new TreeNode(1);
        node.left = node_1;
        node.right = node_2;

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

        TreeNode node_9 = new TreeNode(5);
        TreeNode node_10 = new TreeNode(4);
        node_5.left = node_9;
        node_6.right = node_10;

        SymmetricTreeV1 st = new SymmetricTreeV1();
        org.junit.Assert.assertEquals(st.isSymmetric(node), true);

        SymmetricTreeV2 st2 = new SymmetricTreeV2();
        org.junit.Assert.assertEquals(st2.isSymmetric(node), true);
    }

}
