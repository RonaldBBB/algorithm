package basic.episode_0永恒经典;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zyf
 * @date: 2021/8/1 23:19
 * @description: 同时维护行数列数以及行列坐标四个值
 */
public class Code03_螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int line = matrix.length-1;
        int row = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        int i=0,j=0;
        while(row!=0){
            for(int k=0;k<row;k++){
                result.add(matrix[i][j++]);
            }
            j--;
            i++;
            row--;
            if(line==0)break;
            for(int k=0;k<line;k++){
                result.add(matrix[i++][j]);
            }
            i--;
            j--;
            line--;
            if(row==0)break;
            for(int k=0;k<row;k++){
                result.add(matrix[i][j--]);
            }
            j++;
            i--;
            row--;
            if(line==0)break;
            for(int k=0;k<line;k++){
                result.add(matrix[i--][j]);
            }
            i++;
            j++;
            line--;
        }
        return result;
    }
}
