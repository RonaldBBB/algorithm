package basic.episode05_Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description 二叉树非递归后序遍历
 * @Date 2021/5/30 23:37
 * @Created by xiaofei
 */
public class Code02_PostOrderTraversalUnRecursive {
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderTraversal(root,result);
        return result;
    }

    private void postorderTraversal(TreeNode root, List<Integer> result) {
        if(root==null)return;
        postorderTraversal(root.left,result);
        postorderTraversal(root.right,result);
        result.add(root.val);
    }

    public List<Integer> postorderTraversalUnRecursive(TreeNode root) {
        if(root==null)return new ArrayList<>();
        // 按照先序遍历相反顺序，根左右的顺序循环压栈弹出 得到顺序根右左
        // 将弹出的元素放到第二个栈中，再依次弹出第二个栈，得到顺序左右根
        LinkedList<TreeNode> stack1 = new LinkedList<>(Collections.singletonList(root));
        LinkedList<TreeNode> stack2 = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        while(!stack1.isEmpty()){
            TreeNode pop = stack1.pop();
            stack2.push(pop);
            if(pop.left!=null)stack1.push(pop.left);
            if(pop.right!=null)stack1.push(pop.right);
        }
        while (!stack2.isEmpty()){
            result.add(stack2.pop().val);
        }
        return result;
    }
}
