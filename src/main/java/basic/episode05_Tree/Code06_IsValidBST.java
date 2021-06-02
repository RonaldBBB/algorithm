package basic.episode05_Tree;

import java.util.Arrays;
import java.util.Collections;

/**
 * @Description 验证是否是二叉搜索树 leetcode98
 * @Date 2021/5/30 23:37
 * @Created by xiaofei
 */
public class Code06_IsValidBST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    long pre = Long.MIN_VALUE;

    // method1:通过中序遍历
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST(root.left)) return false;
        if (root.val <= pre) return false;
        else pre = root.val;
        return isValidBST(root.right);
    }

    // method2:通过递归
    public boolean isValidBSTByRecur(TreeNode root) {
        return process(root).isBST;
    }

    static class ReturnType {
        Integer min;
        Integer max;
        Boolean isBST;

        public ReturnType(Integer min, Integer max, Boolean isBST) {
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }

        public ReturnType() {
        }
    }

    private ReturnType process(TreeNode node) {
        if (node == null) return new ReturnType(null, null, true);
        ReturnType leftResult = process(node.left);
        ReturnType rightResult = process(node.right);
        int min = node.val;
        if (leftResult.min != null) min = Math.min(node.val, leftResult.min);

        int max = node.val;
        if (rightResult.max != null) max = Math.max(node.val, rightResult.max);

        boolean isBST = leftResult.isBST && rightResult.isBST;
        isBST = isBST && (leftResult.max == null || node.val > leftResult.max);
        isBST = isBST && (rightResult.min == null || node.val < rightResult.min);
        return new ReturnType(min, max, isBST);
    }
}
