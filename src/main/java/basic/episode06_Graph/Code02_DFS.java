package basic.episode06_Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @Description 深度优先遍历
 * @Date 2021/6/2 14:31
 * @Created by xiaofei
 */
public class Code02_DFS {
    // 横向对比二叉树非递归的前序优先遍历
    // 1.当栈不为空时循环
    // 2.弹出一个节点,如果能够找到相邻的not visited节点
    // 3.先将当前节点压回栈中,再将相邻节点压入栈中并标记为visited
    public void dfs(Node root){
       if(root==null)return;
        LinkedList<Node> stack = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        stack.push(root);
        visited.add(root);
        System.out.println(root.value);
        while(!stack.isEmpty()){
            Node pop = stack.pop();
            for(Node node : pop.nexts){
                if(!visited.contains(node)){
                    System.out.println(node.value);
                    visited.add(node);
                    // 关键代码：将弹出的节点压回栈中
                    stack.push(pop);
                    stack.push(node);
                    // 关键代码： 深度优先，找到一个当前层节点就往下层走
                    break;
                }
            }

        }
    }
}
