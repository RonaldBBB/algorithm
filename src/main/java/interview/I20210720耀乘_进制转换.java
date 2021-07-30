package interview;

import java.util.ArrayList;

/**
 * @author: zyf
 * @date: 2021/7/20 19:12
 * @description: 纯coding leetcode504
 */
public class I20210720耀乘_进制转换 {
    // 十进制转十六进制
    public static String tenToHex(int i) {
        ArrayList<Character> list = new ArrayList<>();
        while(i!=0){
            int temp = i%16;
            list.add(intToChar(temp));
            i/=16;
        }
        StringBuilder sb = new StringBuilder();
        for(int j = list.size()-1;j>=0;j--){
            sb.append(list.get(j));
        }
        return sb.toString();
    }

    public static int hexToTen(String str){
        char[] chars = str.toCharArray();
        int result = 0;
        int help = 1;
        for(int i=chars.length-1;i>=0;i--){
            result+=help*charToInt(chars[i]);
            help*=16;
        }
        return result;
    }

    public static int charToInt(char c){
        if(c>'0'&&c<'9')return c-'0';
        else return c-'A'+10;
    }

    private static Character intToChar(int temp) {
        if(temp<10) return (char)('0'+temp);
        else return (char)('A'+temp-10);
    }

    public static void main(String[] args) {
        System.out.println(tenToHex(102234));
        System.out.println(hexToTen("18F5A"));
    }

}
