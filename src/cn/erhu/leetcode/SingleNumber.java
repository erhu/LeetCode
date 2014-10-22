package cn.erhu.leetcode;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * <p/>
 * Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p/>
 * User: hujunjie
 * Date: 14-10-22
 * Time: 下午6:36
 */
public class SingleNumber {
    /**
     * 原理：相同的数进行异或运算，结果为0
     */
    public int singleNumber(int[] arr) {
        if (arr == null) {
            return -404;
        }

        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = arr[i] ^ result;
        }
        return result;
    }
}
