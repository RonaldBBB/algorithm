package basic.episode06_Graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 拓扑排序 课程表 leetcode207
 * @Date 2021/6/2 14:31
 * @Created by xiaofei
 */
public class Code04_CanFinishCourse {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Node> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new Node());
        }
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).nexts.add(graph.get(prerequisite[0]));
            graph.get(prerequisite[0]).in++;
        }

        Map<Node, Integer> InCountMap = new HashMap<>();
        // 已经完成的课程数量
        int count = 0;
        for (Node node : graph.values()) {
            InCountMap.put(node, node.in);
        }
        while (!InCountMap.isEmpty()) {
            boolean flag=false;
            for (Node node : InCountMap.keySet()) {
                if (InCountMap.get(node).equals(0)) {
                    for (Node next : node.nexts) {
                        InCountMap.put(next,InCountMap.get(next)-1);
                    }
                    flag = true;
                    count++;
                    InCountMap.remove(node);
                    break;
                }
            }
            if(!flag)break;
        }
        return count == numCourses;
    }

    static class Node{
        int in;
        List<Node> nexts;
    }
}
