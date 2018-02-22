package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new BufferedReader(new InputStreamReader(System.in)).readLine()));
        String line;
        while ((line = reader.readLine()) != null) {
          if (line.startsWith(args[0]+" ")) System.out.println(line);
        }
        reader.close();
    }
}
