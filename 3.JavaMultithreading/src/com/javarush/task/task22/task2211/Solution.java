package com.javarush.task.task22.task2211;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;


/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        try(FileInputStream fr = new FileInputStream(args[0]);
            FileOutputStream fw = new FileOutputStream(args[1])
                ){
            byte[] bufer = new byte[1000];
            Charset utf_8 = StandardCharsets.UTF_8;
            Charset windows1251 = Charset.forName("Windows-1251");

            while (fr.available() > 0){
                fr.read(bufer);
                String s = new String(bufer, windows1251);
                bufer = s.getBytes(utf_8);
                fw.write(bufer);
            }
        }catch (IOException e){}
    }
}
