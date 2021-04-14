package com.cloud.web.util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.text.NumberFormat;

public class FileCountUtil {
    public static void main(String[] args) {
        int ajsp = 0;
        int ajs = 0;
        int maxjsp=0;
        int maxjs = 0;
        int minjsp=1000000000;
        int minjs=1000000000;
        int mountjsp = 0;
        int mountjs = 0;
        int count0 = 0;
        int count10 = 0;
        int count20 = 0;
        int count2000 = 0;
        int count1000 = 0;
        int count500 = 0;
        int count500down = 0;

        int count4000js=0;
        int count2000js=0;
        int count1000js=0;
        int count500js=0;
        int count500downjs=0;
        File dir = new File("F:\\js");
        File[] files = dir.listFiles(); // 该文件目录下文件全部放入数组
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(2);
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                try{
                    if(files[i].exists()){
                        File file = files[i];
                        String name = file.getName();
                        if("jsp".equals(name.substring(name.length()-3))){
                            ajsp++;
                            mountjsp++;
                            FileReader fr = new FileReader(files[i]);
                            LineNumberReader lnr = new LineNumberReader(fr);
                            int linenumber = 0;
                            while (lnr.readLine() != null){
                                linenumber++;
                            }
                            System.out.println("Total number of lines : " + linenumber);
                            if(linenumber > 2000 ){
                                count2000++;
                            }else if(linenumber > 1000){
                                count1000++;
                            }else if(linenumber > 500){
                                count500++;
                            }else{
                                count500down++;
                            }
                            if(maxjsp<linenumber){
                                maxjsp=linenumber;
                            }
                            if(minjsp>linenumber){
                                minjsp=linenumber;
                            }
                            ajsp+=linenumber;
                            lnr.close();
                        }
                        if("js".equals(name.substring(name.length()-2))){
                            ajs++;
                            mountjs++;
                            FileReader fr = new FileReader(files[i]);
                            LineNumberReader lnr = new LineNumberReader(fr);
                            int linenumber = 0;
                            while (lnr.readLine() != null){
                                linenumber++;
                            }
                            System.out.println("Total number of lines : " + linenumber);
                            if(linenumber > 4000){
                                count4000js++;
                            }else if(linenumber > 2000){
                                count2000js++;
                            }else if(linenumber > 1000){
                                count1000js++;
                            }else if(linenumber > 500){
                                count500js++;
                            }else{
                                count500downjs++;
                            }
                            if(maxjs<linenumber){
                                maxjs=linenumber;
                            }
                            if(minjs>linenumber){
                                minjs=linenumber;
                            }
                            ajs+=linenumber;
                            lnr.close();
                        }
                    }else{
                        System.out.println("File does not exists!");
                    }
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
        String percent2000jsp = numberFormat.format((float) count2000 / (float) mountjsp * 100);
        String percent1000jsp = numberFormat.format((float)count1000/(float)mountjsp*100);
        String percent500jsp = numberFormat.format((float)count500/(float)mountjsp*100);
        String percent500downjsp = numberFormat.format((float)count500down/(float)mountjsp*100);

        String percent2000js = numberFormat.format((float) count2000js / (float) mountjs * 100);
        String percent1000js = numberFormat.format((float)count1000js/(float)mountjs*100);
        String percent500js = numberFormat.format((float)count500js/(float)mountjs*100);
        String percent4000js = numberFormat.format((float)count4000js/(float)mountjs*100);
        String percent500downjs = numberFormat.format((float)count500downjs/(float)mountjs*100);

        System.out.println("jsp文件总行数"+ajsp+",js文件总行数"+ajs);
        System.out.println("jsp文件最大行数为"+maxjsp+",js文件最大行数为"+maxjs);
        System.out.println("jsp文件最小行数为"+minjsp+",js文件最小行数为"+minjs);
        System.out.println("jsp文件个数"+mountjsp+",js文件个数"+mountjs);
        System.out.println("jsp文件avg line"+ajsp/mountjsp+",js文件平均行数"+ajs/mountjs);
        System.out.println("jsp---begin");
        System.out.println("大于2000行的文件有"+count2000+"百分比"+percent2000jsp);
        System.out.println("1000-2000行之间有"+count1000+"百分比"+percent1000jsp);
        System.out.println("1000-500行之间有"+count500+"百分比"+percent500jsp);
        System.out.println("小于500行的有"+count500down+"百分比"+percent500downjsp);
        System.out.println("jsp---end");
        System.out.println("js---begin");
        System.out.println("大于4000行的文件有"+count4000js+"百分比"+percent4000js);
        System.out.println("大于2000行的文件有"+count2000js+"百分比"+percent2000js);
        System.out.println("大于1000行的文件有"+count1000js+"百分比"+percent1000js);
        System.out.println("大于500行的文件有"+count500js+"百分比"+percent500js);
        System.out.println("小于500行的文件有"+count500downjs+"百分比"+percent500downjs);
        System.out.println("js---end");
    }
}
