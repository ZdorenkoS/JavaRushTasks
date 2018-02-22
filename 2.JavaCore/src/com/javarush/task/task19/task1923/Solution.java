package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fr =new BufferedReader(new FileReader(args[0]));
        FileWriter fw = new FileWriter(args[1]);
        while (fr.ready()){
            String []s= new String [100];
            s=fr.readLine().split(" ");
            for (int i = 0; i <s.length ; i++) {
                if ((s[i].replaceAll("\\d","").length())-s[i].length()<0) fw.write(s[i]+" ");
            }

        }
        fr.close();
        fw.flush();
        fw.close();

    }
}
