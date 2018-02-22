package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream  is = new FileInputStream(args[1]);
        FileOutputStream os = new FileOutputStream(args[2]);
        byte [] bayt = new byte[8*1024];
        int count;
        while ((count=is.read(bayt))!=-1){
            if (args[0].equals("-e")){
                for (int i = 0; i <bayt.length-1 ; i++) {
                    bayt[i]++;
                }}

            if (args[0].equals("-d")){
                    for (int i = 0; i <bayt.length-1 ; i++) {
                        bayt[i]--;
                    }}
            os.write(bayt,0, count);
            }
         is.close();
         os.close();
        }
    }


