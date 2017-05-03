package com.straydog.learnjava.io;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Created by jyyc on 2017/5/3.
 */
public class GZIPInputStreamDemo {

    public static void main(String[] args) {

        //打包zip包
        //writeReadmeZip();
        readZipFile();
    }

    private static void readZipFile() {
        File zipFile = new File("Readme.zip");
        GZIPInputStream in = null;
        try {

            in = new GZIPInputStream(new FileInputStream(zipFile));
            int len = 0;
            byte[] bytes = new byte[1024];
            StringBuffer sb = new StringBuffer();

            while ((len = in.read(bytes))!=-1){
                String str = new String(bytes,0,len,"utf-8");
               // System.out.println(str);
                sb.append(str);
            }
           System.out.println(sb.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    /**
     * 通过InputStream输入流读取README.md文件的内容，通过GZIPOutputStream将读取到的字节写入到README.zip
     */
    private static void writeReadmeZip(){
        File readme = new File("README.md");
        File readmeZip = new File("Readme.zip");
        try {
            InputStream in = new FileInputStream(readme);
            GZIPOutputStream out = new GZIPOutputStream(new FileOutputStream(readmeZip));

            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = in.read(buffer))!=-1){
                out.write(buffer);
            }
            out.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
