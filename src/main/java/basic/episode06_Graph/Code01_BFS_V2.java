package basic.episode06_Graph;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author: zyf
 * @date: 2021/6/27 16:58
 * @description:
 */
public class Code01_BFS_V2 {
    LinkedList<Integer>[] adjacent;
    int num;

    public Code01_BFS_V2(LinkedList<Integer>[] adjacent) {
        this.adjacent = adjacent;
        num = adjacent.length;
    }

    public void bfs(int start, int end) {
        if (start == end) {
            return;
        }
        int[] prev = new int[num];
        int[] visited = new int[num];
        Arrays.fill(prev, -1);
        Arrays.fill(visited, -1);
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (queue.size() != 0) {
            Integer poll = queue.poll();
            for (int i = 0; i < adjacent[poll].size(); i++) {
                int next = adjacent[poll].get(i);
                if (visited[next] != -1) {
                    prev[next] = poll;
                    if (next == end) {
                        print(start, end, prev);
                        return;
                    }
                    visited[next] = 1;
                    queue.add(next);
                }
            }
        }


    }

    private void print(int start, int end, int[] prev) {
        if (start != end && prev[end] != -1) {
            print(start, prev[end], prev);
        }
        System.out.println(end);
    }
}
