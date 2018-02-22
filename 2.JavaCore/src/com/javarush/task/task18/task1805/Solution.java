package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        reader.close();
        FileInputStream fis = new FileInputStream(s);

        TreeSet<Integer> set = new TreeSet<Integer>();

        while (fis.available() > 0) {
            set.add(fis.read());
        }
        fis.close();



        Iterator iterator = set.iterator();
        while (iterator.hasNext())        //проверка, есть ли ещё элементы
        {
            //получение текущего элемента и переход на следующий
            String text = iterator.next().toString();

            System.out.print(text+" ");
        }


    }
}
