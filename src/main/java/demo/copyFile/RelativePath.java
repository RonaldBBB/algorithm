package demo.copyFile;

import java.io.File;

/**
 * @author: zyf
 * @date: 2021/3/7 11:01
 * @description:
 */
public class RelativePath {
    public static void main(String[] args) {
        File file = new File(".");
        System.out.println(file.getAbsolutePath());
    }
}
