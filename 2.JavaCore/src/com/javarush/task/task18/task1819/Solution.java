package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String f1 = br.readLine();
        String f2 = br.readLine();
        br.close();
        FileInputStream fis1 = new FileInputStream(f1);
        byte [] buffer1 = new byte[fis1.available()];
        fis1.read(buffer1);
        fis1.close();

        FileOutputStream fos1 = new FileOutputStream(f1);
        FileInputStream fis2 = new FileInputStream(f2);
        byte [] buffer2 = new byte[fis2.available()];
        fis2.read(buffer2);
        fis2.close();

        fos1.write(buffer2);
        fos1.write(buffer1);
        fos1.close();


    }
}
