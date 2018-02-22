package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fr =new BufferedReader(new FileReader(args[0]));
        FileWriter fw = new FileWriter(args[1]);
        StringBuilder sb = new StringBuilder();
        while (fr.ready()){
            String []s= new String [100];
            s=fr.readLine().split(" ");
            for (int i = 0; i <s.length ; i++) if (s[i].length()>6) {sb.append(s[i]+",");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        fw.write(sb.toString());
        fr.close();
        fw.flush();
        fw.close();

    }
}
