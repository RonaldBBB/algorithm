package basic.episode05_Tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 验证是否是平衡二叉树 leetcode110
 * @Date 2021/5/30 23:37
 * @Created by xiaofei
 */
public class Code08_IsBalancedTree {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static public class ReturnType {
        int height;
        boolean isBalanced;
    }

    public boolean isBalanced(TreeNode root) {
        return process(root).isBalanced;
    }

    public ReturnType process(TreeNode node) {
        if (node == null) return new ReturnType(0, true);
        ReturnType leftResult = process(node.left);
        ReturnType rightResult = process(node.right);
        int height = Math.max(leftResult.height, rightResult.height) + 1;
        boolean isBalanced = leftResult.isBalanced && rightResult.isBalanced
                && Math.abs(leftResult.height - rightResult.height) <= 1;
        return new ReturnType(height, isBalanced);
    }


}
