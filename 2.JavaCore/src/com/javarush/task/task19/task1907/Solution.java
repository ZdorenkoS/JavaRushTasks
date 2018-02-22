package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file1 = br.readLine();
        br.close();

        FileReader fr = new FileReader(file1);
        StringBuilder strBld = new StringBuilder();
        while (fr.ready()) strBld.append((char)fr.read());
        fr.close();

        String[] parts = strBld.toString().split("\\W");
        int count = 0;
        for (String x : parts) if (x.equals("world")) count++;
        System.out.println(count);}}