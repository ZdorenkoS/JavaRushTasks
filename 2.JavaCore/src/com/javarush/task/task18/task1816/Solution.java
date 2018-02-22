package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new FileReader(args[0]));
        StringBuilder sb=new StringBuilder();
        while(reader.ready())sb.append(reader.readLine());
        reader.close();
        System.out.println((sb+"\0").split("[a-zA-Z]").length-1);
    }
}
