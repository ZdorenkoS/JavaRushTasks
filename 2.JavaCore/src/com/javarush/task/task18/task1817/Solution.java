package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args)  {
        int countSpace=0;
        int countSymbol=0;
        try(FileInputStream fileIS = new FileInputStream(args[0])){
            byte[] buff = new byte[fileIS.available()];
            fileIS.read(buff);
            for(byte b:buff) {
                if (b==' ') {
                    countSpace++;
                    countSymbol++;
                }
                else countSymbol++;
            }
            double result = (double) countSpace/countSymbol*100;
            System.out.println(String.format("%.2f", result));
        }catch (FileNotFoundException e){}catch (IOException e){}
    }
}
