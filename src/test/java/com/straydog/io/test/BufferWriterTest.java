package com.straydog.io.test;

import org.junit.Test;

import java.io.*;

/**
 * Created by jyyc on 2017/5/3.
 */
public class BufferWriterTest {

    @Test
    public void addNumberTest(){
        File readme = new File("README.md");
        File readme2 = new File("Readme2.md");
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(readme),"utf-8"));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(readme2),"utf-8"));

            String line = null;
            int count = 1;
            while ((line = in.readLine())!=null){
                System.out.println(count + "." + "  " + line );
                out.write(count + "." + "  " + line);
                out.newLine();
                count++;
            }
            out.close();
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void delNumberTest(){
        File readme2 = new File("Readme2.md");
        File readme3 = new File("Readme3.md");

        try {
            BufferedReader brin = new BufferedReader(new InputStreamReader(new FileInputStream(readme2),"utf-8"));
            BufferedWriter brout = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(readme3),"utf-8"));

            String line =null;
            int count =1;
            while ((line = brin.readLine())!=null){
                if (line.indexOf(".")!=-1){
                    line = line.replace(".","").replace(String.valueOf(count),"").replace(" ","");
                    brout.write(line);
                    brout.newLine();
                    System.out.println(line);
                    count++;
                }
            }

            brout.close();
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
