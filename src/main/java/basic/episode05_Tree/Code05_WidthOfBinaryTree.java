package basic.episode05_Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description 二叉树的最大宽度 leetcode662
 * @Date 2021/5/30 23:37
 * @Created by xiaofei
 */
public class Code05_WidthOfBinaryTree {

    static public class TreeNode {
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

    static class AnnotatedNode{
        TreeNode node;
        int position;
        AnnotatedNode(TreeNode node,int position){
            this.node = node;
            this.position = position;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)return 0;
        Queue<AnnotatedNode> queue = new LinkedList<>();
        queue.add(new AnnotatedNode(root,1));
        int maxWidth = Integer.MIN_VALUE;
        int left=-1;
        while(!queue.isEmpty()){
            // 通过size可以获取层次遍历中的一整行
            int size = queue.size();
            for(int i=0;i<size;i++){
                AnnotatedNode cur = queue.remove();
                if(i==0)left = cur.position;
                if(cur.node.left!=null)queue.add(new AnnotatedNode(cur.node.left,2*cur.position+1));
                if(cur.node.right!=null)queue.add(new AnnotatedNode(cur.node.right,2*cur.position+2));
                if(i==size-1)maxWidth=Math.max(maxWidth,cur.position-left+1);
            }
        }
        return maxWidth;
    }
}
