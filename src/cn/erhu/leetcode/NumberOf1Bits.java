package cn.erhu.leetcode;

import org.junit.Test;

/**
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).
 * <p/>
 * For example, the 32-bit integer '11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 *
 * @author hujunjie
 * @version 1.0
 * @since 15-3-10 上午10:01
 */
public class NumberOf1Bits {

    /**
     * todo 这个解法的原理还未搞清楚
     * <p/>
     * MIT Hamming
     */
    public int hammingWeight(int n) {
        n -= n >>> 1 & 0x55555555;
        n = (n & 0x33333333) + (n >>> 2 & 0x33333333);
        n = n + (n >>> 4) & 0xF0F0F0F;
        n += n >>> 8;
        n += n >>> 16;
        return n & 63;

        //return Integer.bitCount(n);

        // 常规解法
/*
        if (n > Integer.MAX_VALUE) {
            return 0;
        }
        int count = 0;
        while (n > 0) {
            if (n % 2 == 1) {
                count++;
            }
            n /= 2;
        }
        return count;
        */
    }

    @Test
    public void test() {
        System.out.println(Integer.toBinaryString(1));
        System.out.println(hammingWeight(1));

        System.out.println(Integer.toBinaryString(2));
        System.out.println(hammingWeight(2));

        System.out.println(Integer.toBinaryString(54));
        System.out.println(hammingWeight(54));

        System.out.println(Integer.toBinaryString(11));
        System.out.println(hammingWeight(11));

        System.out.println(Integer.toBinaryString(12));
        System.out.println(hammingWeight(12));

        System.out.println(Integer.toBinaryString(13));
        System.out.println(hammingWeight(13));
    }
}
