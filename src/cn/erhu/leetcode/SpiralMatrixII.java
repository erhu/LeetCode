package cn.erhu.leetcode;

/**
 * Spiral(['spaɪrəl]) Matrix 螺旋矩阵
 * <p/>
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * <p/>
 * For example, Given n = 3,
 * <p/>
 * You should return the following matrix:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 * <p/>
 * User: hujunjie
 * Date: 14-10-17
 * Time: 下午5:48
 */
public class SpiralMatrixII {

    int[][] arr;
    int n;

    // 格子的初始位置在第一行第一个元素的左边；
    int i = 0;
    int j = -1;
    int currentIndex = 1;

    // 第一个格子的移动方向为向右
    Direction currentDirection = Direction.RIGHT;

    public int[][] generateMatrix(int n) {
        this.n = n;
        arr = new int[n][n];
        while (currentIndex <= n * n) {
            move();
        }
        return arr;
    }

    void move() {
        if (currentDirection == Direction.RIGHT) {
            if (checkIndex(i, j + 1)) {
                j++;
                arr[i][j] = currentIndex;
                currentIndex++;
            } else {
                turn();
            }
        } else if (currentDirection == Direction.DOWN) {
            if (checkIndex(i + 1, j)) {
                i++;
                arr[i][j] = currentIndex;
                currentIndex++;
            } else {
                turn();
            }
        } else if (currentDirection == Direction.LEFT) {
            if (checkIndex(i, j - 1)) {
                j--;
                arr[i][j] = currentIndex;
                currentIndex++;
            } else {
                turn();
            }
        } else if (currentDirection == Direction.UP) {
            if (checkIndex(i - 1, j)) {
                i--;
                arr[i][j] = currentIndex;
                currentIndex++;
            } else {
                turn();
            }
        }
    }

    void turn() {
        if (currentDirection == Direction.RIGHT) {
            currentDirection = Direction.DOWN;
        } else if (currentDirection == Direction.DOWN) {
            currentDirection = Direction.LEFT;
        } else if (currentDirection == Direction.LEFT) {
            currentDirection = Direction.UP;
        } else if (currentDirection == Direction.UP) {
            currentDirection = Direction.RIGHT;
        }
    }


    /**
     * 检查下标是否越界，且为非初始值(0)
     *
     * @param i 一维下标（竖）
     * @param j 二维下标（横）
     */
    boolean checkIndex(int i, int j) {
        return !(i < 0 || i > n - 1 || j < 0 || j > n - 1) && arr[i][j] == 0;
    }

    /**
     * 移动方向
     */
    enum Direction {
        RIGHT, DOWN, LEFT, UP
    }
}
