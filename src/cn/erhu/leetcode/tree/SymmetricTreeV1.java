package cn.erhu.leetcode.tree;

/**
 * SymmetricTree
 * <p/>
 * User: hujunjie
 * Date: 14-10-17
 * Time: 下午3:26
 */
public class SymmetricTreeV1 {
    /**
     * 此版本未通过leetCode测试，提示超时。
     */
    public boolean isSymmetric(TreeNode root) {
        if (root != null) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            if (left == null && right == null) {
                return true;
            }

            // 遍历左子树（顺序：左中右）
            String left_node_val = travelLeft(new StringBuilder(), left);

            // 遍历右子树（顺序：右中左）
            String right_node_val = travelRight(new StringBuilder(), right);

            // 比较遍历结果是否相等
            return left_node_val.equals(right_node_val);
        }
        return false;
    }

    String travelLeft(StringBuilder builder, TreeNode tree) {
        if (tree == null) {
            return "";
        }
        if (tree.left != null) {
            builder.append(travelLeft(builder, tree.left));
        }
        builder.append(tree.val);
        if (tree.right != null) {
            builder.append(travelLeft(builder, tree.right));
        }
        return builder.toString();
    }

    String travelRight(StringBuilder builder, TreeNode tree) {
        if (tree == null) {
            return "";
        }
        if (tree.right != null) {
            builder.append(travelRight(builder, tree.right));
        }
        builder.append(tree.val);
        if (tree.left != null) {
            builder.append(travelRight(builder, tree.left));
        }
        return builder.toString();
    }
}
