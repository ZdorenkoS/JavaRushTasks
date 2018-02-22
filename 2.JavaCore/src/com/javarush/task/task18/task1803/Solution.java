package com.javarush.task.task18.task1803;

import sun.rmi.log.LogInputStream;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        FileInputStream fis = new FileInputStream(s);

        ArrayList<Integer> list = new ArrayList<Integer>();

        while (fis.available() > 0) {
            list.add(fis.read());
        }
        fis.close();

        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            if (Collections.frequency(list, list.get(i)) > max) ;
            max = Collections.frequency(list, list.get(i));
        }

        for (int i = 0; i < list.size(); i++) {
            if (Collections.frequency(list, list.get(i)) == max) {
                System.out.print(list.get(i) + " ");
                for (int j = i+1; j < list.size(); j++) {
                    if (list.get(j)==list.get(i)) list.remove(j);
                }
            }

        }
    }}
