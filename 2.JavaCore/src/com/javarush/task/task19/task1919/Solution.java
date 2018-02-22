package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args){
        Map<String, Double> map = new TreeMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))){
        while (br.ready()){
        String s = br.readLine();
        int probel = s.indexOf(" ");
        String key = s.substring(0,probel);
        double value = Double.parseDouble(s.substring(probel+1));
        if(map.get(key)!=null) map.put(key, map.get(key)+value);
            else map.put(key,value);
       }} catch (IOException e){
            System.out.println("gdfsg");
        }


        for (Map.Entry<String, Double> pair : map.entrySet())
        {
            String key = pair.getKey();                      //ключ
            double value = pair.getValue();                  //значение
            System.out.println(key + " " + value);
        }
    }
}
