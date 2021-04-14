package com.cloud.web.util;

import java.io.File;

public class Demo {
    //获取d:/206workspace下的所有的目录以及子目录中以.java结尾的文件的绝对路径
    public static void main(String[] args) {
        File file = new File("d:/Myeclipse-2014/project/test01");
        Demo demo = new Demo();
        demo.getPath(file);
    }
    public void  getPath(File file){
        File[] files = file.listFiles();//返回该目录下的子目录以及文件对应的File实例
        for(File f:files){
            if(f.isDirectory()){//判断是否是目录
                getPath(f);
            }else{
                if(f.getName().endsWith(".java")){//判断文件名是否以.java结尾D:/Myeclipse-2014/project
                    System.out.println(f.getAbsolutePath());//获取文件的绝对路径
                }
            }
        }
    }
}
