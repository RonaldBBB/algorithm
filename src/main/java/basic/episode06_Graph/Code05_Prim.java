package basic.episode06_Graph;

import java.util.Arrays;

/**
 * @Description Prim 最小生成树
 * @Date 2021/8/24 22:26
 * @Created by xiaofei
 */
public class Code05_Prim {
    public int minCost(int N,int[][] roads){
        int[][] graph = new int[N][N];
        for (int[] ints : graph) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        for(int[] arr:roads){
            graph[arr[0]-1][arr[1]-1]=arr[3]==1?0:arr[2];
        }
        return prim(graph);
    }
    public static int prim(int[][] graph) {
        int size = graph.length;
        int[] distances = new int[size];
        boolean[] visit = new boolean[size];
        visit[0] = true;
        for (int i = 0; i < size; i++) {
            distances[i] = graph[0][i];
        }
        int sum = 0;
        for (int i = 1; i < size; i++) {
            int minPath = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int j = 0; j < size; j++) {
                if (!visit[j] && distances[j] < minPath) {
                    minPath = distances[j];
                    minIndex = j;
                }
            }
            if (minIndex == -1) {
                return sum;
            }
            visit[minIndex] = true;
            sum += minPath;
            for (int j = 0; j < size; j++) {
                if (!visit[j] && distances[j] > graph[minIndex][j]) {
                    distances[j] = graph[minIndex][j];
                }
            }
        }
        return sum;
    }

}
