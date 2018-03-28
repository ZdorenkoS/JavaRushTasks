package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) {
        StringBuilder cities = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader fr = new BufferedReader(new FileReader(br.readLine()))){
            while (fr.ready()){
                cities.append(fr.readLine());
            }
        }
        catch (IOException e){}
        String [] s = (cities.toString()).split(" ");
        Arrays.sort(s);
        StringBuilder result = getLine(s);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        if (words.length==0) return new StringBuilder();
        StringBuilder sb = new StringBuilder();
        ArrayList<String> list = new ArrayList<>(Arrays.asList(words));
        char c =list.get(0).charAt(list.get(0).length()-1);
        sb.append(list.get(0)+" "); list.remove(0);
        for (int i = 0; i <list.size() ; i++) {
            if (Character.toLowerCase(list.get(i).charAt(0))==c)
            {sb.append(list.get(i) + " ");
             c= list.get(i).charAt(list.get(i).length()-1);
                list.remove(i);
                i=0;}
            else { continue;}
        }

        for (String s : list) {sb.append(s + " ");}
          sb.deleteCharAt(sb.length()-1);
          return sb;
    }
}
