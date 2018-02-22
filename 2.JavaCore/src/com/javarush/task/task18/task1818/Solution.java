package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file1 = br.readLine();
        String file2 = br.readLine();
        String file3 = br.readLine();
        br.close();
        FileOutputStream fos1= new FileOutputStream(file1);
        FileInputStream fis2 = new FileInputStream(file2);
        FileInputStream fis3 = new FileInputStream(file3);

        byte[] buffer = new byte[1000];

        while (fis2.available()>0){
            int count = fis2.read(buffer);
            fos1.write(buffer, 0, count);
        }
        while (fis3.available()>0){
            int count = fis3.read(buffer);
            fos1.write(buffer, 0, count);
        }


        fis2.close();
        fis3.close();
        fos1.close();
    }
}
