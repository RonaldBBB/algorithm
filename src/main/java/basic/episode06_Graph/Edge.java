package basic.episode06_Graph;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 边模板
 * @Date 2021/6/2 14:31
 * @Created by xiaofei
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Edge {
    public int weight;
    public Node in;
    public Node out;
}
