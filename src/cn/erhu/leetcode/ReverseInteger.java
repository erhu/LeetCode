package cn.erhu.leetcode;

/**
 * Reverse digits of an integer.
 * <p/>
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * <p/>
 * click to show spoilers.
 * <p/>
 * Have you thought about this?
 * Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!
 * <p/>
 * If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
 * <p/>
 * Did you notice that the reversed integer might overflow?
 * Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?
 * <p/>
 * Throw an exception? Good, but what if throwing an exception is not an option?
 * You would then have to re-design the function (ie, add an extra parameter).
 * <p/>
 * User: hujunjie
 * Date: 14-10-23
 * Time: 上午10:22
 */
public class ReverseInteger {
    public int reverse(int _x) {
        int x = _x;
        if (_x < 0) {
            x = -_x;
        }

        String str_x = String.valueOf(x);
        char[] char_arr = str_x.toCharArray();
        int len = char_arr.length;
        for (int i = 0; i <= (len - 1) / 2; i++) {
            int end_index = (len - 1) - i;
            char tmp = char_arr[end_index];
            char_arr[end_index] = char_arr[i];
            char_arr[i] = tmp;
        }

        String str_val = String.valueOf(char_arr);
        if (_x < 0) {
            str_val = "-" + str_val;
        }

        // Integer的最大值为 Math.pow(2, 31) - 1，这里先转成long，以防止溢出；
        Long result = Long.parseLong(str_val);
        if (result > Integer.MAX_VALUE) {
            return 0;
        }
        return result.intValue();
    }

    /**
     * 这个版本比上一个更简单，高效。
     */
    public int reverseV2(int _x) {
        int x = _x < 0 ? -_x : _x;
        long out = 0;

        while (x > 0) {
            out = out * 10 + x % 10;
            x /= 10;
        }
        long val = _x < 0 ? out * -1 : out;
        if (val > Integer.MAX_VALUE || val < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) val;
    }
}
