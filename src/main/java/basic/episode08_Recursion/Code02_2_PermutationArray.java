package basic.episode08_Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: zyf
 * @date: 2021/8/5 21:07
 * @description:
 */
public class Code02_2_PermutationArray {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> numList = new LinkedList<>();
        for(int n:nums)numList.add(n);
        int length = numList.size();
        permute(new ArrayList<>(),numList,length);
        return result;
    }

    public void permute(List<Integer> already,LinkedList<Integer> numList,int length){
        if(already.size()==length){
            result.add(new ArrayList<Integer>(already));
        }
        for(int i=0;i<numList.size();i++){
            int temp = numList.remove();
            already.add(temp);
            permute(already,numList,length);
            already.remove(already.size()-1);
            numList.add(temp);
        }
    }
}
