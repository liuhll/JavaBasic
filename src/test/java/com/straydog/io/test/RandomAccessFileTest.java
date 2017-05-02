package com.straydog.io.test;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by Hongliang.Liu on 2017/5/2.
 */
public class RandomAccessFileTest {

    @Test
    public void RafTest1(){
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            raf1 = new RandomAccessFile(new File("newFile"), "r");
            raf2 = new RandomAccessFile(new File("hello1.txt"),"rw");

            byte[] b = new byte[20];
            int len;
            while((len = raf1.read(b)) != -1){
                raf2.write(b, 0, len);
                System.out.println("当前文件指针在:" + raf2.getFilePointer());
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            if(raf2 != null){
                try {
                    raf2.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(raf1 != null){
                try {
                    raf1.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}
