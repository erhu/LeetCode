package cn.erhu.leetcode;

/**
 * You are given an n x n 2D matrix representing an image.
 * <p/>
 * Rotate the image by 90 degrees (clockwise).
 * <p/>
 * Follow up:
 * Could you do this in-place?
 * <p/>
 * User: hujunjie
 * Date: 14-10-22
 * Time: 下午4:11
 */
public class RotateImage {

    public void rotate(int[][] matrix) {
        transpose(matrix);
        horizontalReverse(matrix);
    }

    /**
     * 转置（交换矩阵中的行和列）
     */
    void transpose(int[][] m) {
        if (m != null) {
            int n = m.length;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    exchange(m, i, j, j, i);
                }
            }
        }
    }

    /**
     * 将矩阵进行左右翻转
     */
    void horizontalReverse(int[][] m) {
        if (m != null) {
            int n = m.length;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= (n - 1) / 2; j++) {
                    exchange(m, i, j, i, n - j - 1);
                }
            }
        }
    }

    /**
     * 交换矩阵 m[i_1][j_1] 和 m[i_2][j_2] 的值
     */
    void exchange(int[][] m, int i_1, int j_1, int i_2, int j_2) {
        if (m != null && validIndex(m, i_1, j_1) && validIndex(m, j_1, j_2)) {
            int tmp = m[i_1][j_1];
            m[i_1][j_1] = m[i_2][j_2];
            m[i_2][j_2] = tmp;
        }
    }

    boolean validIndex(int[][] m, int i, int j) {
        return m != null && i >= 0 && i < m.length && j >= 0 && j < m[0].length;
    }
}
