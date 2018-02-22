package com.javarush.task.task19.task1922;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fr = new BufferedReader(new FileReader(br.readLine()));
        br.close();
        int count =0;
        while (fr.ready()){
            String s = fr.readLine();
            String s1=s+" ";
            for (int i = 0; i <words.size() ; i++) {
               count+= s1.split(words.get(i)).length-1;
            }
            if(count==2) System.out.println(s);
            count=0;
            }
        fr.close();


    }
    }

