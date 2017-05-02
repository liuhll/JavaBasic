package com.straydog.learnjava.io;

import java.io.File;
import java.io.IOException;

/**
 * Created by Hongliang.Liu on 2017/5/2.
 */
public class FileDemo {

    public static void main(String[] args) {

        // File 类对象代表的是文件|文件夹本身，
        File file = new File(".");

        System.out.println("是否是目录:" + file.isDirectory());
        System.out.println("是否存在:" + file.exists());
        System.out.println("绝对路径:" + file.getAbsolutePath());

        File dir1 = new File("./DirDemo");
        if (!dir1.exists()){
            dir1.mkdir();
            System.out.println("目录名称:" + dir1.toString());
            System.out.println(dir1);
        }else {
            dir1.delete();
        }

        File newFile = new File(".","newFile");
        if (!newFile.exists()){
            try {
                newFile.createNewFile();
                System.out.println("文件名" + newFile.toString());
                System.out.println(newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            newFile.delete();
        }


    }
}
