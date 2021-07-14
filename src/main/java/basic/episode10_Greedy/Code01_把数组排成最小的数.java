package basic.episode10_Greedy;

import java.util.*;

/**
 * @author: zyf
 * @date: 2021/6/30 21:05
 * @description: offer45
 */
public class Code01_把数组排成最小的数 {

    public String minNumber(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i:nums)list.add(i);
        list.sort(new myComparator());
        StringBuilder sb = new StringBuilder();
        for(int i:list){
            sb.append(i);
        }
        return sb.toString();
    }


    static class myComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer left, Integer right) {
            String lr = left.toString()+right.toString();
            String rl = right.toString()+left.toString();
            return Integer.parseInt(lr)-Integer.parseInt(rl);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Code01_把数组排成最小的数().minNumber(new int[]{3, 30, 34, 5, 9}));

    }

}
