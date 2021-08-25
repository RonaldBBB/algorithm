package interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description TODO
 * @Date 2021/8/21 21:10
 * @Created by xiaofei
 */
public class I20210821趋势_通配符匹配 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String regex = sc.next();
        String list = sc.next();
        list = list.substring(1,list.length()-1);
        String[] strs = list.split(",");

        List<String> result = new ArrayList<>();
        for (int i=0;i<strs.length;i++) {
            strs[i] = strs[i].substring(1,strs[i].length()-1);
            if(match(regex,strs[i]))result.add(strs[i]);
        }
        if(result.isEmpty()) System.out.println("Not Match");
        else for (String s : result) {
            System.out.print(s);
            System.out.print(" ");
        }
    }

    private static boolean match(String regex, String str) {
        if("*".equals(regex))return true;
        String[] regexList = regex.split("\\.");
        String[] strList = str.split("\\.");
        int strIndex = strList.length-1;
        int regexIndex = regexList.length-1;
        while(regexIndex>0){
            if(!regexList[regexIndex].equals(strList[strIndex])&&!regexList[regexIndex].equals("*"))return false;
            strIndex--;
            regexIndex--;
        }
        if(strList[0].equals("*"))return true;
        return strIndex == 0 && (regexList[0].equals(strList[0]));
    }

    //a.*.com ["a.test.com","a.b.com","b.c.com"]
}
