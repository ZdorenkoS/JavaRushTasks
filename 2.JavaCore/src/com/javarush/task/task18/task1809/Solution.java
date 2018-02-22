package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String s2 = reader.readLine();
        reader.close();
        FileInputStream fis = new FileInputStream(s);
        FileOutputStream fos = new FileOutputStream(s2);

        ArrayList<Integer> list = new ArrayList<>();


        while (fis.available() > 0) {
            list.add(fis.read());
        }
        fis.close();

        Collections.reverse(list);

        for (int i = 0; i < list.size(); i++) {
            fos.write(list.get(i));
        }

        fos.close();
    }
}
