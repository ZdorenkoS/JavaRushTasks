package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
      /* String [] s = getTokens("level22.lesson13.task01", ".");
        for (String str : s) {
            System.out.print(str);
        }*/
    }
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        ArrayList<String> list = new ArrayList<>();
        list.add("{");
         while (tokenizer.hasMoreTokens()) {
            list.add("\""+tokenizer.nextToken()+"\"");
            if (tokenizer.hasMoreTokens())list.add(", ");
        }
        list.add("}");
         return list.toArray(new String[list.size()]);
    }
}
