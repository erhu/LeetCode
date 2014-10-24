package cn.erhu.leetcode;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * <p/>
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * <p/>
 * Note: The sequence of integers will be represented as a string.
 * <p/>
 * User: hujunjie
 * Date: 14-10-24
 * Time: 下午2:32
 */
public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        } else {
            return _countAndSay(countAndSay(n - 1));
        }
    }

    String _countAndSay(String _str) {
        char[] arr = _str.toCharArray();
        StringBuilder builder = new StringBuilder();
        char prev = arr[0];
        int count = 1;
        int i = 1;

        while (i < arr.length) {
            // 上一个字符和当前字符相同， 增加计数。
            if (arr[i] == prev) {
                count++;
            } else {
                // 如果不同，重围计数器，输入计数结果。
                builder.append(count).append(prev);
                prev = arr[i];
                count = 1;
            }
            i++;
        }

        builder.append(count).append(prev);
        return builder.toString();
    }
}
