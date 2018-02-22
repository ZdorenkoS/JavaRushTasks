package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream is = new FileInputStream(args[0]);
        int [] b = new int[256];
        int bayt;
        while ((bayt=is.read())!=-1){
            b[bayt]+=1;

        }
        is.close();
        for (int i = 0; i <b.length-1 ; i++) {
            if (b[i]>0) {
                byte bb = (byte) i;

                System.out.println( (char)bb+" "+b[i]);
            }
        }
    }
}
