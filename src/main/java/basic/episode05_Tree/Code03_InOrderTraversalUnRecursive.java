package basic.episode05_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description 二叉树非递归中序遍历
 * @Date 2021/5/30 23:37
 * @Created by xiaofei
 */
public class Code03_InOrderTraversalUnRecursive {
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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root,result);
        return result;
    }

    private void inorderTraversal(TreeNode root, List<Integer> result) {
        if(root==null)return;
        inorderTraversal(root.left,result);
        result.add(root.val);
        inorderTraversal(root.right,result);
    }

    public List<Integer> inorderTraversalUnRecursive(TreeNode root) {
        if(root==null)return new ArrayList<>();
        LinkedList<TreeNode> stack  = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        // 持续向左孩子方向压栈直到左孩子为空，取出最近的右孩子重复这一过程
        // 代码有点技巧
        while(!stack.isEmpty()||root!=null){
            if(root!=null){
                stack.push(root);
                root = root.left;
            }else{
                TreeNode pop = stack.pop();
                result.add(pop.val);
                root = pop.right;
            }
        }
        return result;
    }

}
