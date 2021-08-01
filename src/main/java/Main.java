import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: zyf
 * @date: 2021/7/19 20:01
 * @description:
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(letterCombinations(""));
    }

    public static List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<>();
        if(digits.length()==0)return result;
        int begin = (digits.charAt(0)-'0'-2)*3;
        for(int i=0;i<3;i++){
            result.add(new String(new char[]{(char)('a'+begin+i)}));
        }
        for(int i=1;i<digits.length();i++){
            int size = result.size();
            for(int j=0;j<size;j++){
                int innerBegin = (digits.charAt(i)-'0'-2)*3;
                String temp = result.remove();
                for(int k=0;k<size;k++){
                    result.add(temp+(char)('a'+innerBegin+k));
                }
            }
        }

        return result;
    }
}
