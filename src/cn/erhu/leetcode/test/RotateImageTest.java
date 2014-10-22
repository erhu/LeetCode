package cn.erhu.leetcode.test;

import cn.erhu.leetcode.RotateImage;
import org.junit.Test;

/**
 * #本文件的功能说明#
 * <p/>
 * User: hujunjie
 * Date: 14-10-22
 * Time: 下午4:23
 */
public class RotateImageTest {

    @Test
    public void test() {
        Matrix m = new Matrix();
        m.matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        RotateImage ri = new RotateImage();
        ri.rotate(m.matrix);
        System.out.println(m);

        m.matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        ri.rotate(m.matrix);
        System.out.println(m);
    }

    static class Matrix {
        int[][] matrix;

        @Override
        public String toString() {
            if (matrix == null) {
                return "";
            }
            StringBuilder builder = new StringBuilder();
            for (int[] m1 : matrix) {
                for (int m2 : m1) {
                    builder.append(m2).append(",");
                }
                builder.append("\n");
            }

            return builder.toString();
        }
    }
}
