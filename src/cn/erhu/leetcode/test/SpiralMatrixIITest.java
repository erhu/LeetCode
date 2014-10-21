package cn.erhu.leetcode.test;

import cn.erhu.leetcode.SpiralMatrixII;
import org.junit.Test;

import java.util.Arrays;

/**
 * #本文件的功能说明#
 * <p/>
 * User: hujunjie
 * Date: 14-10-17
 * Time: 下午5:51
 */
public class SpiralMatrixIITest {

    @Test
    public void test() {
        SpiralMatrixII sm = new SpiralMatrixII();
        int[][] arr = sm.generateMatrix(5);
        for (int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }
    }
}
