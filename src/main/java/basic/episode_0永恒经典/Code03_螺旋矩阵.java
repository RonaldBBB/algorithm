package basic.episode_0永恒经典;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zyf
 * @date: 2021/8/1 23:19
 * @description: lc54
 */
public class Code03_螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int lurow = 0,lucol=0,rdrow = matrix.length-1,rdcol=matrix[0].length-1;
        while(lurow<=rdrow&&lucol<=rdcol){
            doSpiralOrder(matrix,lurow++,lucol++,rdrow--,rdcol--,result);
        }
        return result;
    }

    public void doSpiralOrder(int[][] matrix,int lurow,int lucol,int rdrow,int rdcol,List<Integer> result){
        for(int i=lucol;i<=rdcol;i++){
            result.add(matrix[lurow][i]);
        }
        if(lurow==rdrow)return;
        for(int i=lurow+1;i<=rdrow;i++){
            result.add(matrix[i][rdcol]);
        }
        if(lucol==rdcol)return;
        for(int i=rdcol-1;i>=lucol;i--){
            result.add(matrix[rdrow][i]);
        }
        for(int i=rdrow-1;i>lurow;i--){
            result.add(matrix[i][lucol]);
        }
    }
}
