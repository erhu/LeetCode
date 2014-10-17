package cn.erhu.leetcode;

import org.junit.Test;

/**
 * #本文件的功能说明#
 * <p/>
 * User: hujunjie
 * Date: 14-10-15
 * Time: 上午10:46
 */
class ReverseWords {

    @Test
    public void test() {
        String s = "  today  is  ";
        org.junit.Assert.assertEquals(reverseWords(s), "is today");
        s = "today    is   a fine day";
        org.junit.Assert.assertEquals(reverseWords(s), "day fine a is today");
    }

    String reverseWords(String _content) {
        if (_content != null && _content.length() > 0) {
            _content = trimBlank(_content.trim());
            char[] source_arr = _content.toCharArray();
            int len = source_arr.length;

            // 用于标识单词的范围
            int i = 0, j = 0;

            while (i < source_arr.length - 1) {
                while (j < source_arr.length && source_arr[j] != ' ') {
                    j++;
                }

                // 翻转一个单词
                _reverse(source_arr, i, j - 1);
                i = j;

                while (j < len && source_arr[j] == ' ') {
                    j++;
                    i++;
                }
            }

            // 翻转所有字符
            _reverse(source_arr);
            return String.valueOf(source_arr);
        }
        return "";
    }

    void _reverse(char[] _char_arr) {
        _reverse(_char_arr, 0, _char_arr.length - 1);
    }

    void _reverse(char[] _char_arr, int _begin, int _end) {
        if (_char_arr != null) {
            while (_begin < _end) {
                exchange(_char_arr, _begin, _end);
                _begin++;
                _end--;
            }
        }
    }

    /**
     * 去除字符串中重复的空格
     * <p/>
     * remove repeated white space, include the one in the mid of string.
     */
    String trimBlank(String str) {
        if (str != null) {
            char[] arr = str.trim().toCharArray();
            char[] arr_copy = new char[arr.length];
            int valid_char_index = 0;
            boolean prev_blank = true;

            for (char a_char : arr) {
                if (a_char == ' ') {
                    // 如果上一个不是空格，且当前字符是空格，此字符有效
                    if (!prev_blank) {
                        arr_copy[valid_char_index] = a_char;
                        valid_char_index++;
                    } else {
                        // 不添加这个空白字符
                    }
                    prev_blank = true;
                } else {
                    arr_copy[valid_char_index] = a_char;
                    valid_char_index++;
                    prev_blank = false;
                }
            }
            return String.valueOf(arr_copy, 0, valid_char_index);
        }
        return null;
    }

    void exchange(char[] arr, int i, int j) {
        if (i < 0 || i > arr.length - 1 || j < 0 || j > arr.length - 1) {
            return;
        }
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
