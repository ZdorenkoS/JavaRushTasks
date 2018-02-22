package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file1  = br.readLine();
        String file2  = br.readLine();
        br.close();

        BufferedReader reader1 = new BufferedReader(new FileReader(file1));
        BufferedReader reader2 = new BufferedReader(new FileReader(file2));

        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();


        while (reader1.ready()){
         list1.add(reader1.readLine());
        }

        while (reader2.ready()){
            list2.add(reader2.readLine());
        }
        reader1.close();
        reader2.close();

        int count1=0;
        int count2=0;

       while(true) {
            try{
                if(list1.get(count1).equals(list2.get(count2))) {lines.add(new LineItem(Type.SAME, list1.get(count1)));
                count1++; count2++;}
                else {
                    if (list1.get(count1).equals(list2.get(count2+1))) {lines.add(new LineItem(Type.ADDED, list2.get(count2)));
                    count2++;}
                    else {lines.add(new LineItem(Type.REMOVED, list1.get(count1)));
                    count1++;}}
            }catch (IndexOutOfBoundsException e){
                if(count2>list2.size()-1)  lines.add(new LineItem(Type.REMOVED, list1.get(count1)));
                if(count1>list1.size()-1)  lines.add(new LineItem(Type.ADDED, list2.get(count2)));
                break;}
        }

        for (int i = 0; i <lines.size() ; i++) {
            System.out.println(lines.get(i).type +" "+ lines.get(i).line);
        }

    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
