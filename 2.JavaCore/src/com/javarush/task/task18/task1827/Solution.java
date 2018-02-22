package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import sun.nio.cs.UTF_32;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        br.close();
        int temp, max=0;


        switch (args[0]){
            case "-c":{
                BufferedReader  fr = new BufferedReader (new FileReader(fileName));
                String line;
                while ((line = fr.readLine())!=null){

                       temp=Integer.valueOf(line.substring(0,8).trim());
                  if(temp>max) max=temp;
                }
             fr.close();
             StringBuilder sb = new StringBuilder();
             sb.append(max+1);      while (sb.length()<8)  sb.append(" ");
             sb.append(args[1]);    while (sb.length()<38) sb.append(" ");
             sb.append(args[2]);    while (sb.length()<46) sb.append(" ");
             sb.append(args[3]);    while (sb.length()<50) sb.append(" ");

            FileOutputStream os = new FileOutputStream(fileName, true);

                os.write(sb.toString().getBytes());
                os.flush();
                os.close();
            }

            default:break;

        }



    }
}
