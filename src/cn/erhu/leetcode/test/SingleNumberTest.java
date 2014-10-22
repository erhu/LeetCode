package cn.erhu.leetcode.test;

import cn.erhu.leetcode.SingleNumber;
import org.junit.Test;

/**
 * #本文件的功能说明#
 * <p/>
 * User: hujunjie
 * Date: 14-10-22
 * Time: 下午6:39
 */
public class SingleNumberTest {

    @Test
    public void test() {
        int[] arr = {2, 3, 2, 3, 4};
        System.out.println(new SingleNumber().singleNumber(arr));
    }
}
