package com.straydog.io.test;

import org.junit.Test;

import java.io.*;

/**
 * Created by jyyc on 2017/5/3.
 */
public class BufferedReaderTest {

    /**
     *  使用BufferedReader按字符流读取文件，文件编码与读取编码不一致时会出现乱码
     */
    @Test
    public void TestRead1(){
        try {
            BufferedReader brIn = new BufferedReader(new FileReader(new File(".//README.md")));
            String line = null;
            while ((line = brIn.readLine())!=null){
                System.out.println(line);
            }
            brIn.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void TestRead2(){
        File readme = new File("./README.md");

        try {
            //为什么要对FileInputStream进行再一次封装，为了使用InputStreamReader对字节和字符进行转换；
            //为什么要对InputStreamReader进行再一次封装，为了使用BufferedReader的readline方法；
            BufferedReader brin = new BufferedReader(new InputStreamReader(new FileInputStream(readme),"utf-8"));

            String line = null;
            while ((line = brin.readLine())!=null){
                System.out.println(line);
            }
            brin.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
