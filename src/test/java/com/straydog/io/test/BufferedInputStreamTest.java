package com.straydog.io.test;

import org.junit.Test;

import java.io.*;

/**
 * Created by jyyc on 2017/5/3.
 */
public class BufferedInputStreamTest {

    @Test
    public void renameTest(){

        File srcImg = new File("src\\resources\\images\\io.jpg");
        File dtsImg = new File("src\\resources\\images\\io_2.jpg");

        try {
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(srcImg));
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(dtsImg));

            //每次读写内容的长度
            int len = 0;
            //设置缓存区大小为1mb
            byte[] bytes = new byte[1024];

            while (( len = in.read(bytes))!=-1){
                out.write(bytes);
            }
            out.close();
            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
