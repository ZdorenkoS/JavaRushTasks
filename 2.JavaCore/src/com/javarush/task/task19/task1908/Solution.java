package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileIn  = br.readLine();
        String fileOut = br.readLine();
        br.close();

        BufferedReader reader = new BufferedReader(new FileReader(fileIn));
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileOut));
        String [] s=new String[1000];
        while (reader.ready()){
            s = reader.readLine().split(" ");
            for (int i = 0; i <s.length ; i++) {
              if (s[i].matches("\\b\\d+")) {if (i==1)writer.write(s[i]);
                else writer.write(" "+s[i]);}
            }
         }
        reader.close();
        writer.flush();
        writer.close();

    }
}
