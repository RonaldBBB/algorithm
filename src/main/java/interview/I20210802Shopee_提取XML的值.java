package interview;

/**
 * @author: zyf
 * @date: 2021/8/2 21:00
 * @description: 提取XML的值 纯coding
 * 给定一个简单XML字符串，可能包含XML的嵌套，输入一个路径，输出对应路径的值，如果不存在则返回空字符串
 */
public class I20210802Shopee_提取XML的值 {
    public String GetXMLValue(String inxml, String path) {
        String[] splits = inxml.split(">");
        int index = 0;
        String result = "";
        StringBuilder realPath = new StringBuilder();
        for (int i = 0; i < splits.length; i++) {
            if (!splits[i].startsWith("<")) {
                index = i;
                result = splits[i].split("<")[0];
                break;
            }
        }
        for (int i = 0; i < index; i++) {
            realPath.append(splits[i].substring(1));
            realPath.append(".");
        }
        realPath.deleteCharAt(realPath.length() - 1);
        if (path.equals(realPath.toString())) return result;
        else return "";
    }

}
