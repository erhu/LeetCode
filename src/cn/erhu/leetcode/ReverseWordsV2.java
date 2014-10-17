package cn.erhu.leetcode;

import org.junit.Test;

/**
 * #本文件的功能说明#
 * <p/>
 * User: hujunjie
 * Date: 14-10-15
 * Time: 下午6:13
 */
class ReverseWordsV2 {
    @Test
    public void test() {
        String s = "  today  is  ";
        org.junit.Assert.assertEquals(reverseWords(s), "is today");
        s = "today    is   a fine day";
        org.junit.Assert.assertEquals(reverseWords(s), "day fine a is today");
    }

    String reverseWords(String s) {
        StringBuilder builder = new StringBuilder();
        int j = s.length();

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                // 将 j 往前移
                j = i;
            }
            // 到了字符串头部 或者 i左边的字符是空白符
            else if (i == 0 || s.charAt(i - 1) == ' ') {
                if (builder.length() != 0) {
                    builder.append(' ');
                }
                builder.append(s.substring(i, j));
            }
        }
        return builder.toString();
    }
}
