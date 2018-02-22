package com.javarush.task.task19.task1909;

/* 
Замена знаков
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
        while (reader.ready()){
           int i= reader.read();
                if (i==46) writer.write(33); else writer.write(i);
        }
        reader.close();
        writer.flush();
        writer.close();
    }
}
