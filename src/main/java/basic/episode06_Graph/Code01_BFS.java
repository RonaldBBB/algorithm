package basic.episode06_Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @Description 宽度优先遍历
 * @Date 2021/6/2 14:31
 * @Created by xiaofei
 */
public class Code01_BFS {

    // 思路和二叉树的层次遍历一致,除了需要使用Set保存所有访问过的节点
    public void bfs(Node node){
        if(node == null)return;
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        queue.add(node);
        while(!queue.isEmpty()){
            int size = queue.size();
            // 和二叉树层次遍历一样，这种写法可以获得某一层的所有数据
            for(int i =0;i<size;i++){
                Node remove = queue.remove();
                System.out.println(remove.value);
                for(Node n:remove.nexts){
                    if(!visited.contains(n)){
                        queue.add(n);
                        visited.add(n);
                    }
                }
            }
        }
    }

}
