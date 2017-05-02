package com.straydog.learnjava.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hongliang.Liu on 2017/5/2.
 */
public class FileUtils {

    private static List<File> dirList;

    private static File[] getDirectorys(String dirPath,boolean isRecursion) throws IOException{

        File dir = new File(dirPath);
        if (!dir.exists()){
            throw new IllegalArgumentException("不存在该目录");
        }
        if (!dir.isDirectory()){
            throw new IllegalArgumentException("您给定的不是有效的路径");
        }

        if (!isRecursion){
            dirList = new ArrayList<File>();
        }


        File[] files = dir.listFiles();

        if (files !=null && files.length >0)
        for (File file: files){
            if (file.isDirectory()){
                dirList.add(file);
                getDirectorys(file.getAbsolutePath(),true);
            }
        }

        File[] dirArray = new File[dirList.size()];
        dirArray = dirList.toArray(dirArray);

        return dirArray;

    }

    public static File[] getDirectorys(String dirPath) throws IOException {

        return getDirectorys(dirPath,false);
    }

}
