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
public class NumberOf1BitsDetail {

    // mask for sum every 2 bits : 01010101010101010101010101010101
    private static final int MASK_SUM_EVERY_2_BIT = 0x55555555;

    // mask for sum every 4 bits : 00110011001100110011001100110011
    private static final int MASK_SUM_EVERY_4_BIT = 0x33333333;

    // mask for sum every 8 bits
    private static final int MASK_SUM_EVERY_8_BIT = 0x0f0f0f0f;

    // mask for sum every 16 bits
    private static final int MASK_SUM_EVERY_16_BIT = 0x00ff00ff;

    // mask for sum every 32 bits
    private static final int MASK_SUM_EVERY_32_BIT = 0x0000ffff;

    /**
     * Hamming weight algo.
     */
    public int hammingWeight(int n) {
        // n = 54
        // System.out.println(Integer.toBinaryString(0x33333333));
        // Integer.parseInt("110110", 2);
        // count: 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 1 0 1 1 0
        // 注: 解释中只保留后6位(前面都为0)

        int count = 54;

        {   // 分步解释:
            // 1. count & MASK_SUM_EVERY_2_BIT          -> 奇数位不变, 偶数位变为0
            // 2. count >> 1                            -> 将原来偶数位上的数值, 向右移一格, 放到奇数位上
            // 3. (count >> 1) & MASK_SUM_EVERY_2_BIT   -> 由于第2步的移位操作, 故此语句的意思是:使第一步中,不变的位(奇数位)变为0, 第1步中的偶数位不变

            System.out.println(Integer.toBinaryString(count));                              // 110110
            System.out.println(Integer.toBinaryString(count & MASK_SUM_EVERY_2_BIT));       // 010100
            System.out.println(Integer.toBinaryString(count >> 1));                         // 011011
            System.out.println(Integer.toBinaryString((count >> 1) & MASK_SUM_EVERY_2_BIT));// 010001

            // 4. 第 1 步保留了 count 的奇数位, 第 3 步保留了 count 的偶数位
            // 第1步结果 + 第3步结果 = 3组bit(每组bit表示count相邻的两个bit位相加的结果:有几个'1')
            //   010100
            // + 010001
            // ---------
            //   100101   -> 分成3组(10)(01)(01), 分别表示(2)(1)(1),即 count 中有2 + 1 + 1个'1'
            count = (count & MASK_SUM_EVERY_2_BIT) + ((count >> 1) & MASK_SUM_EVERY_2_BIT);

            System.out.println(Integer.toBinaryString(count));// 100101
        }

        System.out.println("------------------------------------------------");

        {   // 同理有:
            // 1. count & MASK_SUM_EVERY_4_BIT          -> 从右往左数, 每四位中,第1, 2位不变,第3, 4位变为0
            // 2. count >> 2                            -> 将原来在3, 4位上的数值, 向右移2格, 放到第1, 2位上
            // 3. (count >> 2) & MASK_SUM_EVERY_4_BIT   -> 从右往左数, 保留每四位中的第3, 4位

            System.out.println(Integer.toBinaryString(count));                              // 100101
            System.out.println(Integer.toBinaryString(count & MASK_SUM_EVERY_4_BIT));       // 100001
            System.out.println(Integer.toBinaryString(count >> 2));                         // 001001
            System.out.println(Integer.toBinaryString((count >> 2) & MASK_SUM_EVERY_4_BIT));// 000001

            // 4. 第 1 步保留了 count 的奇数位, 第 3 步保留了 count 的偶数位
            // 第1步结果 + 第3步结果 = 3组bit(每组bit表示count相邻的两个bit位相加的结果:有几个'1')
            //   00100001
            // + 00000001
            // ----------
            //   00100010   -> 分成2组(0010)(0010), 分别表示(2)(2),即 count 中有2 + 2个'1'
            count = (count & MASK_SUM_EVERY_4_BIT) + ((count >> 2) & MASK_SUM_EVERY_4_BIT);

            System.out.println(Integer.toBinaryString(count));// 100010
        }

        count = (count & MASK_SUM_EVERY_8_BIT) + ((count >> 4) & MASK_SUM_EVERY_8_BIT);
        count = (count & MASK_SUM_EVERY_16_BIT) + ((count >> 8) & MASK_SUM_EVERY_16_BIT);
        count = (count & MASK_SUM_EVERY_32_BIT) + ((count >> 16) & MASK_SUM_EVERY_32_BIT);
        return count;
    }

    @Test
    public void test() {
        System.out.println(Integer.toBinaryString(54));
        System.out.println(hammingWeight(54));
    }

    /**
     * 10进制转二进制
     */
    private String d2b(int n) {
        String str = "";
        while (n > 0) {
            if (n % 2 == 1) {
                str = "1" + str;
            } else {
                str = "0" + str;
            }
            n /= 2;
        }
        return str;
    }
}
