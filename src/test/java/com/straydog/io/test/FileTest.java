package com.straydog.io.test;

import com.straydog.learnjava.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by Hongliang.Liu on 2017/5/2.
 */
public class FileTest {

    @Test
    public void FileUitilsTest(){

        try {
            File[] dirs = FileUtils.getDirectorys("C:\\Users\\Administrator\\Desktop\\个人简历");

            for(File file : dirs){
                System.out.println(file);
            }
            Assert.assertNotNull(dirs);
            Assert.assertTrue(dirs.length == 3 );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void FilePathSeparatorTest(){
        String osName = System.getProperties().get("os.name").toString();

        if (osName == null){
           Assert.assertTrue("获取系统名称失败",false);
        }
        if (osName.toLowerCase().contains("windows")){
            Assert.assertEquals("判断windows系统字符分隔符","\\",File.separator);
        }
        else
        {
            Assert.assertEquals("判断linux系统字符分隔符","/",File.separator);
        }
        System.out.println(File.separator);
    }
}
