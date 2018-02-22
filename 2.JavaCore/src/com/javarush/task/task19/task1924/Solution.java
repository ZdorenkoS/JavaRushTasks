package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file = br.readLine();
        BufferedReader fr = new BufferedReader(new FileReader(file));
        br.close();

        while (fr.ready()) {
            StringBuilder sb = new StringBuilder();
            String s = fr.readLine();
            for (String str:s.split("\\s")) {
                try {
                Integer i = Integer.parseInt(str);
                if (map.containsKey(i)) sb.append(map.get(i)+" "); else sb.append(str+" ");}
                catch (NumberFormatException e) {sb.append(str+" ");}
            }
            System.out.println(sb.toString().trim());
        }
        fr.close();
    }
}
