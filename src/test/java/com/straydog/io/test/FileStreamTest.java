package com.straydog.io.test;

import org.junit.Test;
import sun.security.krb5.internal.crypto.Des;

import java.io.*;

/**
 * Created by jyyc on 2017/5/3.
 */
public class FileStreamTest {

    @Test
    public void renameTest(){
        File srcImg = new File("src\\resources\\images\\io.jpg");
        File dtsImg = new File("src\\resources\\images\\io_3.jpg");

        try {
            FileInputStream fin = new FileInputStream(srcImg);
            FileOutputStream fou = new FileOutputStream(dtsImg);

            //缓存区大小
            byte[] bytes = new byte[1024];

            //每次读取到内容长度
            int len = 0;
            while ((len = fin.read(bytes))!=-1){
                fou.write(bytes);
            }
            System.out.print("文件重命名成功");
            fou.close();
            fin.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
