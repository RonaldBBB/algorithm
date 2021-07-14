package basic.episode08_Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * 剑指offer38 leetcode567
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 字符串无重复全排序（所谓分支限界）
 * leetcode46 数组全排列
 * leetcode47 数组无重复全排列
 * @Date 2021/6/17 21:35
 * @Created by xiaofei
 */
public class Code02_Permutation {
    List<String> result = new ArrayList<>();

    public String[] permutation(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        ArrayList<Character> charList = new ArrayList<>();
        for(char c:chars)charList.add(c);
        permutation(sb,charList);
        return result.toArray(new String[0]);
    }

    public void permutation(StringBuilder already,List<Character> charList){
        if(charList.size()==0)result.add(already.toString());
        boolean[] visited = new boolean[26];
        for(int i=0;i<charList.size();i++){
            Character temp = charList.remove(0);
            if(!visited[temp - 'a']){
                visited[temp-'a']=true;
                already.append(temp);
                permutation(already,charList);
                charList.add(temp);
                already.deleteCharAt(already.length()-1);
            }else{
                charList.add(temp);
            }
        }
    }
}
