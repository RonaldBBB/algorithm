package demo.copyFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author: zyf
 * @date: 2021/3/7 10:34
 * @description: 通过字节输入输出流复制文件
 */
public class CopyFileWithBytes {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream(new File("./src/main/java/com/zyf/demo/copyFile/from/coder_must.flv"));
             FileOutputStream fos = new FileOutputStream(new File("D:\\project\\java\\basic-algorithm\\src\\main\\java\\com\\zyf\\demo\\copyFile\\dest\\coder_must.flv"))) {
            byte[] temp = new byte[1024];
            int len = 0;
            while((len = fis.read(temp))!=-1){
                fos.write(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
