package cn.erhu.leetcode;

import java.util.Arrays;

import org.junit.Test;

/**
 * Rotate an array of n elements to the right by k steps.
 * <p/>
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * <p/>
 * <p/>
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 *
 * @author hujunjie
 * @version 1.0
 * @since 15-3-14 上午10:27
 */
public class RotateArray {

    public void rotate(int[] num, int k) {
        int[] num_copy = new int[num.length];
        System.arraycopy(num, 0, num_copy, 0, num.length);

//         System.out.println(Arrays.toString(num_copy));

        int len = num_copy.length;
        for (int i = 0; i < len; i++) {
            int index = i + k;
            if (index >= len) {
                index = index % len;
            }
            num[index] = num_copy[i];
        }
        System.out.println(Arrays.toString(num));
    }

    @Test
    public void test() {
        rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        rotate(new int[]{1, 2}, 1);
    }

}
