package basic.episode05_Tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * @Description 二叉树非递归前序遍历
 * @Date 2021/5/30 23:37
 * @Created by xiaofei
 */
public class Code01_PreOrderTraversalUnRecursive {
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

    // 递归前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversal(root,result);
        return result;
    }

    private void preorderTraversal(TreeNode root, List<Integer> result) {
        if(root==null)return;
        result.add(root.val);
        preorderTraversal(root.left,result);
        preorderTraversal(root.right,result);
    }

    public List<Integer> preorderTraversalUnRecursive(TreeNode root){
        if(root==null)return new ArrayList<>();
        // 按照根右左的顺序循环压栈弹出即可
        LinkedList<TreeNode> stack = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            result.add(cur.val);
            if(cur.right!=null)stack.push(cur.right);
            if(cur.left!=null)stack.push(cur.left);
        }
        return result;
    }
}
