package cn.erhu.leetcode.test;

import cn.erhu.leetcode.ReverseInteger;
import org.junit.Test;

/**
 * #本文件的功能说明#
 * <p/>
 * User: hujunjie
 * Date: 14-10-23
 * Time: 上午10:22
 */
public class ReverseIntegerTest {

    @Test
    public void test() {
        org.junit.Assert.assertEquals(new ReverseInteger().reverseV2(123), 321);
        org.junit.Assert.assertEquals(new ReverseInteger().reverseV2(-1234), -4321);
        org.junit.Assert.assertEquals(new ReverseInteger().reverseV2(0), 0);
        org.junit.Assert.assertEquals(new ReverseInteger().reverseV2(1000), 1);
        org.junit.Assert.assertEquals(new ReverseInteger().reverseV2(1000000003), 0);
    }
}
