package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s=reader.readLine();
        reader.close();
        FileInputStream fis= new FileInputStream(s);
        int max=0;
        while (fis.available()>0){
            int temp =fis.read();
            if (temp > max)max=temp;
        }

        fis.close();
        System.out.println(max);
    }
}
