package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {

    public static void main(String[] args) throws IOException {
        final String TAG1 = "<" + args[0];
        final String TAG2 = "</" + args[0] + ">";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fr = new BufferedReader(new FileReader(br.readLine()));
        br.close();
        String s = "";
        while (fr.ready()) {
            s += fr.readLine();
        }
        fr.close();
        s = s.substring(s.indexOf("<"), s.lastIndexOf(">")); // убрали текст за пределами тегов
        String[] words = s.split(">");
        for (int i = 0; i < words.length; i++) {
            words[i] += ">";
        }
            while (true) {
                try {
                ArrayList<Integer> listOpenTag = new ArrayList<>();
                ArrayList<Integer> listCloseTag = new ArrayList<>();
                int count = 0;
                for (int i = 0; i < words.length; i++) {
                    if (words[i].contains(TAG1)) {
                        listOpenTag.add(i);
                        count++;}
                    if (words[i].contains(TAG2)) {
                        listCloseTag.add(i);
                        count--;
                        if (count == 0) break;}
                }
                Collections.reverse(listCloseTag);
                for (int i = 0; i < listOpenTag.size(); i++) {
                    StringBuilder sb = new StringBuilder();
                    for (int j = listOpenTag.get(i); j <= listCloseTag.get(i); j++) {
                        sb.append(words[j]);
                    }
                    String out  =sb.toString();
                    System.out.println(out.substring(out.indexOf("<"),out.lastIndexOf(">")+1));
                }
                words= Arrays.copyOfRange(words,listCloseTag.get(0)+1,words.length);
            }catch (IndexOutOfBoundsException e){break;}
        }
    }
}





