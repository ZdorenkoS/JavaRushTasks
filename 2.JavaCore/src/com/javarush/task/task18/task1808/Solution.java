package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String s1=reader.readLine();
                String s2=reader.readLine();
                String s3=reader.readLine();
            reader.close();
        FileInputStream fis= new FileInputStream(s1);
        FileOutputStream fos2 = new FileOutputStream(s2);
        FileOutputStream fos3 = new FileOutputStream(s3);




        while (fis.available() > 0)
        { byte[] bytes = new byte[fis.available()];
            int count = fis.read(bytes);
            fos2.write(bytes, 0, count - count / 2);
            fos3.write(bytes,  count - count / 2, count/2);
        }
        fis.close();
        fos2.close();
        fos3.close();


        }
    }