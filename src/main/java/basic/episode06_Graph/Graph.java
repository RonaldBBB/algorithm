package basic.episode06_Graph;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Description 图模板
 * @Date 2021/6/2 14:31
 * @Created by xiaofei
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Graph {
    HashMap<Integer,Node> nodes;
    HashSet<Edge> edges;
}
