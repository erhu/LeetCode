package cn.erhu.leetcode.test;

import cn.erhu.leetcode.UniqueBinarySearchTrees;
import org.junit.Test;

/**
 * #本文件的功能说明#
 * <p/>
 * User: hujunjie
 * Date: 14-10-23
 * Time: 下午4:32
 */
public class UniqueBinarySearchTreesTest {
    @Test
    public void test() {
        org.junit.Assert.assertEquals(1, new UniqueBinarySearchTrees().numTrees(1));
        org.junit.Assert.assertEquals(2, new UniqueBinarySearchTrees().numTrees(2));
        org.junit.Assert.assertEquals(5, new UniqueBinarySearchTrees().numTrees(3));
        org.junit.Assert.assertEquals(14, new UniqueBinarySearchTrees().numTrees(4));
        org.junit.Assert.assertEquals(42, new UniqueBinarySearchTrees().numTrees(5));
    }
}
