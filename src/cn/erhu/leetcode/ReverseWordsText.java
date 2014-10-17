package cn.erhu.leetcode;

import org.junit.Test;

/**
 * #本文件的功能说明#
 * <p/>
 * User: hujunjie
 * Date: 14-10-15
 * Time: 下午5:00
 */
class ReverseWordsText {

    @Test
    public void _reverseTest() {
        char[] arr = {'a', 'b', 'c', 'd', ' ', 'e'};
        char[] arr_2 = {'a', 'b', 'c', 'd', 'e', 'f'};

        new ReverseWords()._reverse(arr);
        org.junit.Assert.assertEquals(String.valueOf(arr), "e dcba");
        new ReverseWords()._reverse(arr_2);
        org.junit.Assert.assertEquals(String.valueOf(arr_2), "fedcba");
    }
}
