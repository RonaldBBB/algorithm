package interview;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author: zyf
 * @date: 2021/7/16 20:44
 * @description: HashMap硬写
 */
public class I20210716耀乘_出现频率最高的词组 {
    public ArrayList<ArrayList<String>> frequentWords(String content) {
        ArrayList<ArrayList<String>> resultList = new ArrayList<>();
        String[] split = content.split(" ");
        int result1 = 1;
        HashMap<String, Integer> map1 = new HashMap<>();
        for (int i = 0; i < split.length; i++) {
            if (split[i].endsWith(",") || (split[i].endsWith("."))) {
                split[i] = split[i].substring(0, split[i].length() - 1);
            }
            if (!map1.containsKey(split[i])) {
                map1.put(split[i], 1);
            } else {
                map1.put(split[i], map1.get(split[i]) + 1);
                if (map1.get(split[i]) > result1) result1 = map1.get(split[i]);
            }
        }
        ArrayList<String> resultList1 = new ArrayList<>();
        for (String s : map1.keySet()) {
            if (map1.get(s) == result1) resultList1.add(s);
        }
        resultList.add(resultList1);


        split = content.split(" ");
        int result2 = 1;
        HashMap<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < split.length - 1; i++) {
            if (split[i].endsWith(",") || (split[i].endsWith("."))) {
                continue;
            }
            String temp2 = split[i + 1];
            if (split[i + 1].endsWith(",") || (split[i + 1].endsWith("."))) {
                temp2 = split[i + 1].substring(0, split[i + 1].length() - 1);
            }
            String temp = split[i] + " " + temp2;
            if (!map2.containsKey(temp)) {
                map2.put(temp, 1);
            } else {
                map2.put(temp, map2.get(temp) + 1);
                if (map2.get(temp) > result2) result2 = map2.get(temp);
            }
        }
        ArrayList<String> resultList2 = new ArrayList<>();
        for (String s : map2.keySet()) {
            if (map2.get(s) == result2) resultList2.add(s);
        }
        resultList.add(resultList2);


        split = content.split(" ");
        int result3 = 1;
        HashMap<String, Integer> map3 = new HashMap<>();
        for (int i = 0; i < split.length - 2; i++) {
            String temp3 = split[i + 2];
            if (split[i].endsWith(",") || (split[i].endsWith("."))) {
                continue;
            }
            if (split[i + 1].endsWith(",") || (split[i + 1].endsWith("."))) {
                continue;
            }
            if (split[i + 2].endsWith(",") || (split[i + 2].endsWith("."))) {
                temp3 = split[i + 2].substring(0, split[i + 2].length() - 1);
            }

            String temp = split[i] + " " + split[i + 1] + " " + temp3;
            if (!map3.containsKey(temp)) {
                map3.put(temp, 1);
            } else {
                map3.put(temp, map3.get(temp) + 1);
                if (map3.get(temp) > result3) result3 = map3.get(temp);
            }
        }
        ArrayList<String> resultList3 = new ArrayList<>();
        for (String s : map3.keySet()) {
            if (map3.get(s) == result3) resultList3.add(s);
        }
        resultList.add(resultList3);

        return resultList;
    }
}
