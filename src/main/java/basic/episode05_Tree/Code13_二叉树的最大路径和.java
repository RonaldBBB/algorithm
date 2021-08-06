package basic.episode05_Tree;

/**
 * @author: zyf
 * @date: 2021/8/4 15:44
 * @description: leetcode124
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * <p>
 * 路径和 是路径中各节点值的总和。
 * <p>
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 */
public class Code13_二叉树的最大路径和 {
    static class TreeNode {
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

    int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return result;
    }

    public int maxGain(TreeNode root){
        if(root.left==null&&root.right==null){
            if(root.val>result)result=root.val;
            return root.val;
        }
        int leftMaxGain=0,rightMaxGain=0;
        if(root.left!=null){
            leftMaxGain = Math.max(maxGain(root.left),0);
        }
        if(root.right!=null){
            rightMaxGain = Math.max(maxGain(root.right),0);
        }
        int tempResult = root.val+ leftMaxGain+rightMaxGain;
        if(tempResult>result)result = tempResult;
        return root.val+Math.max(leftMaxGain,rightMaxGain);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new Code13_二叉树的最大路径和().maxPathSum(root));
    }
}
