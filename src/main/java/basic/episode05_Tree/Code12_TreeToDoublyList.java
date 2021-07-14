package basic.episode05_Tree;

import java.util.LinkedList;

/**
 * @author: zyf
 * @date: 2021/6/30 14:54
 * @description:
 */
public class Code12_TreeToDoublyList {
    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    ;

    public Node treeToDoublyList(Node root) {
        if(root==null)return null;
        LinkedList<Node> stack = new LinkedList<>();
        Node result = null;
        Node pre = null;
        Node cur = null;
        while(!stack.isEmpty()||root!=null){
            if(root!=null){
                stack.push(root);
                root=root.left;
            }else{
                cur = stack.pop();

                if(result == null){
                    result = cur;
                    pre = cur;
                }else{
                    pre.right=cur;
                    cur.left=pre;
                    pre = cur;
                }

                root=cur.right;
            }
        }
        pre.right = result;
        result.left = pre;
        return result;
    }

    public static void main(String[] args) {
        final Node root = new Node(4);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n1 = new Node(1);
        Node n5 = new Node(5);
        root.left = n2;
        root.right = n5;
        n2.left = n1;
        n2.right = n3;
        System.out.println(new Code12_TreeToDoublyList().treeToDoublyList(root));
    }
}
