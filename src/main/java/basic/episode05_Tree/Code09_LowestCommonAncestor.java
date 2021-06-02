package basic.episode05_Tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description 最近公共父节点
 * case1: 二叉搜索树的最近公共祖先 剑指offer68 leetcode235
 * case2: 二叉树的最近公共祖先 剑指offer68 leetcode236
 * @Date 2021/5/30 23:37
 * @Created by xiaofei
 */
public class Code09_LowestCommonAncestor {

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // case1: 二叉搜索树的最近公共祖先 剑指offer68 leetcode235
    // 无需遍历
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val < p.val && root.val < q.val) root = root.right;
            else if (root.val > p.val && root.val > q.val) root = root.left;
            else break;
        }
        return root;
    }

    // case2: 二叉树的最近公共祖先 剑指offer68 leetcode236
    public TreeNode lowestCommonAncestorV2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        // step1: 前序遍历获取所有节点的父节点存放于hashmap
        HashMap<TreeNode, TreeNode> fatherMap = new HashMap<>();
        // 初始化root的父节点为root
        fatherMap.put(root, root);
        preOrderTraversal(root, fatherMap);
        Set<TreeNode> fatherOfP = new HashSet<>();
        // step2: 从hashmap中依次获取p的父节点存放于hashset
        fatherOfP.add(p);
        while (p != fatherMap.get(p)) {
            p = fatherMap.get(p);
            fatherOfP.add(p);
        }
        // step3: 从hashmap中依次获取q的父节点在hashset中进行判断
        while (q != fatherMap.get(q)) {
            if (fatherOfP.contains(q)) return q;
            q = fatherMap.get(q);
        }
        return root;
    }

    private void preOrderTraversal(TreeNode root, HashMap<TreeNode, TreeNode> fatherMap) {
        if (root == null) return;
        if (root.left != null) fatherMap.put(root.left, root);
        if (root.right != null) fatherMap.put(root.right, root);
        preOrderTraversal(root.left, fatherMap);
        preOrderTraversal(root.right, fatherMap);
    }

    // case2: 二叉树的最近公共祖先 剑指offer68 leetcode236 递归版本
    public TreeNode lowestCommonAncestorV3(TreeNode root, TreeNode p, TreeNode q) {
        // 这个base case 保证如果子树中含有p或者q那么当前结果必然不为空.
        if (root == null || root == p || root == q) return root;
        TreeNode leftResult = lowestCommonAncestorV3(root.left, p, q);
        TreeNode rightResult = lowestCommonAncestorV3(root.right, p, q);
        if (leftResult != null && rightResult != null) return root;
        return leftResult == null ? rightResult : leftResult;
    }
}
