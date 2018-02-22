package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1 {
    public static void main(String[] args) throws IOException {
        String tag1 = "<" + args[0];
        String tag2 = "</" + args[0] + ">";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fr = new BufferedReader(new FileReader(br.readLine()));

        while (fr.ready()) {
            String s = fr.readLine();
            s = s.substring(s.indexOf(tag1), s.lastIndexOf(tag2) + tag2.length());  // удаляем текст за пределами тегов
            try {
                while (true) {
                    String temp = s.substring(0, s.indexOf(tag2) + tag2.length());      // вырезаем кусок от начала строки до первого закрывающего тега
                    int count = temp.length();
                    // если в куске есть открывающий тег в середине - берем следующеий кусок и ищем в нем закрывающий тег
                    if (temp.contains(tag1) && temp.substring(tag1.length()).contains(tag1)) {
                        while (temp.contains(tag1)) {
                            temp = s.substring(count + 1); // берем следующий кусок изначальной строки
                            temp = temp.substring(0, temp.indexOf(tag2) + tag2.length()); // обрезаем по закрывающий тег
                            count += temp.length();
                        }
                        System.out.println(s.substring(0, count + 1)); // пачатаем найденый кусок строки в котором, на каждый открывающий тег есть закрываюший
                        String temp2=(s.substring(0, count + 1).substring(tag1.length()));
                        System.out.println(temp2.substring(temp2.indexOf(tag1),temp2.indexOf(tag2)+tag2.length()));


                        s = s.substring(count + 1);// откидываем кусок который напечатали
                    } else {
                        System.out.println(temp);
                        s = s.substring(count);
                    }
                }
            }catch (StringIndexOutOfBoundsException e){}
        }
        br.close();
        fr.close();
    }
}
