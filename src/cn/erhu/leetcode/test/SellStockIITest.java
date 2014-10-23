package cn.erhu.leetcode.test;

import cn.erhu.leetcode.SellStockII;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * #本文件的功能说明#
 * <p/>
 * User: hujunjie
 * Date: 14-10-23
 * Time: 下午3:36
 */
public class SellStockIITest {
    @Test
    public void test() {
        int prices[] = {4, 5, 3, 6, 1, 2};
        assertEquals(new SellStockII().maxProfit(prices), 5);
    }
}
