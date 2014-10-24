package cn.erhu.leetcode;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * <p/>
 * https://oj.leetcode.com/problems/unique-binary-search-trees/
 * <p/>
 * User: hujunjie
 * Date: 14-10-23
 * Time: 下午4:19
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if (n == 1 || n == 0) {
            return 1;
        } else {
            int count = 0;
            // 剩余的节点
            int remains = n - 1;

            // 循环将节点分配到左树和右树
            // 左数的节点数递减
            while (remains >= 0) {
                count += (numTrees(remains) * numTrees(n - 1 - remains));
                remains--;
            }
            return count;
        }
    }
}
