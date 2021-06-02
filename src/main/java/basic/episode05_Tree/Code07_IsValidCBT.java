package basic.episode05_Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description 验证是否是完全二叉树 leetcode958
 * @Date 2021/5/30 23:37
 * @Created by xiaofei
 */
public class Code07_IsValidCBT {

    public class TreeNode {
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

    public boolean isCompleteTree(TreeNode root) {
        // 层次遍历
        // 1. 如果当前节点有右孩子没有左孩子直接返回false
        // 2. 如果当前节点有左孩子没有右孩子,那么接下来遍历的所有节点都必须是叶子节点

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 当出现第一个节点孩子不满时置为true
        boolean flag = false;
        while(!queue.isEmpty()){
            TreeNode remove = queue.remove();
            if(remove.left==null&&remove.right!=null)return false;
            if(flag &&(remove.left!=null||remove.right!=null))return false;
            if(remove.left==null||remove.right==null)flag=true;
            if(remove.left!=null)queue.add(remove.left);
            if(remove.right!=null)queue.add(remove.right);
        }
        return true;
    }
}
