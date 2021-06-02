package basic.episode06_Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 拓扑排序
 * @Date 2021/6/2 14:31
 * @Created by xiaofei
 */
public class Code03_TopologySort {
    // 拓扑排序指的是对于一个有向无环图,输出一个线性序列满足以下两个条件
    // 1.每个顶点出现且只出现一次。
    // 2.若存在一条从顶点 A 到顶点 B 的路径，那么在序列中顶点 A 出现在顶点 B 的前面。
    // 在现实世界中对应的模型就是某些事件必须发生于某些事情之前,如何确定一个可以实现的顺序让所有事情都能发生.
    public List<Node> topologySort(Graph graph) {

        // key为节点,value为入度
        Map<Node,Integer> InCountMap = new HashMap<>();
        List<Node> result = new ArrayList<>();
        for(Node node:graph.nodes.values()){
            InCountMap.put(node,node.in);
        }

        // 1.获取一个入度为0的节点
        // 2.将该节点加入结果,并将和该节点关联的所有节点的入度减一
        // 3.重复1和2直到没有节点
        while(!InCountMap.isEmpty()){
            for(Node node:InCountMap.keySet()){
                if(InCountMap.get(node)==0){
                    for(Node n:node.nexts){
                        InCountMap.put(n,InCountMap.get(n)-1);
                    }
                    result.add(node);
                    InCountMap.remove(node);
                    break;
                }
            }
        }
        return result;
    }
}
