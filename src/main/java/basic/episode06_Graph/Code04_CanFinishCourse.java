package basic.episode06_Graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Code04_CanFinishCourse {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,Node> graph = new HashMap<>();
        for(int i=0;i<numCourses;i++){
            graph.put(i,new Node());
        }
        for(int[] prerequest:prerequisites){
            graph.get(prerequest[0]).nexts.add(graph.get(prerequest[1]));
            graph.get(prerequest[1]).in++;
        }

        Map<Node,Integer> InCountMap = new HashMap<>();
        // 已经完成的课程数量
        int count = 0;
        for(Node node:graph.values()){
            InCountMap.put(node,node.in);
        }
        while(!InCountMap.isEmpty()){

        }

    }

    static class Node{
        int in;
        List<Node> nexts;
    }
}
