package cn.erhu.leetcode.test;

import cn.erhu.leetcode.CountAndSay;
import org.junit.Test;

/**
 * #本文件的功能说明#
 * <p/>
 * User: hujunjie
 * Date: 14-10-24
 * Time: 下午2:38
 */
public class CountAndSayTest {

    @Test
    public void test() {
        org.junit.Assert.assertEquals("1", new CountAndSay().countAndSay(1));
        org.junit.Assert.assertEquals("11", new CountAndSay().countAndSay(2));
        org.junit.Assert.assertEquals("21", new CountAndSay().countAndSay(3));
        org.junit.Assert.assertEquals("1211", new CountAndSay().countAndSay(4));
        org.junit.Assert.assertEquals("111221", new CountAndSay().countAndSay(5));
    }
}
