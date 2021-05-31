package demo.copyFile;

import java.io.*;

/**
 * @author: zyf
 * @date: 2021/3/7 11:05
 * @description: 通过字符流复制文本
 */
public class CopyFileWithChars {
    public static void main(String[] args) {
        try(FileReader fr = new FileReader("./src/main/java/com/zyf/demo/copyFile/from/f1.txt");
            FileWriter fw = new FileWriter("./src/main/java/com/zyf/demo/copyFile/dest/f1.txt");
            final BufferedReader br = new BufferedReader(fr);
            final PrintWriter pw = new PrintWriter(fw);
        ) {
            String temp;
            while ((temp = br.readLine())!=null){
                pw.println(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
