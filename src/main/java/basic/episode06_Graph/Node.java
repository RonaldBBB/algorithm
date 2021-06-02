package basic.episode06_Graph;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description 图节点模板
 * @Date 2021/6/2 14:31
 * @Created by xiaofei
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Node {
    public int value;
    public int in;
    public int out;
    // 相邻节点
    public List<Node> nexts;
    // 从当前节点出发的边
    public List<Edge> edges;

    public Node(int value){
        this.value = value;
    }
}
