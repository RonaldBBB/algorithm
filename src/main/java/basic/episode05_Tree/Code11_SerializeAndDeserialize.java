package basic.episode05_Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description 最近公共父节点
 * case1: 序列化和反序列化二叉搜索树 leetcode449
 * case2: 序列化和反序列化二叉树 leetcode297
 * @Date 2021/5/30 23:37
 * @Created by xiaofei
 */
public class Code11_SerializeAndDeserialize {

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // case2: 序列化和反序列化二叉树 leetcode297
    public String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();
        serialize(root,sb);
        System.out.println(">>>>>>>>>>"+sb.toString());
        return sb.toString();
    }

    // 前序遍历节点值用_隔开,遇到null用#代替
    private void serialize(TreeNode root, StringBuilder sb) {
        if(root==null){
            sb.append("#_");
            return;
        }
        sb.append(root.val);
        sb.append('_');
        serialize(root.left,sb);
        serialize(root.right,sb);
    }

    // case2: 序列化和反序列化二叉树 leetcode297
    public TreeNode deserialize(String data) {
        String[] split = data.split("_");
        // 关键在于队列和递归
        Queue<String> queue  = new LinkedList<>(Arrays.asList(split));
        return reconByPreOrder(queue);
    }

    private TreeNode reconByPreOrder(Queue<String> queue) {
        String remove = queue.remove();
        if(remove.equals("#"))return null;
        TreeNode result = new TreeNode(Integer.parseInt(remove));
        result.left = reconByPreOrder(queue);
        result.right = reconByPreOrder(queue);
        return result;
    }
}
