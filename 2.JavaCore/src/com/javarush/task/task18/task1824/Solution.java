package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/



import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name;
        while (true){
           name = br.readLine();
            try (FileInputStream is = new FileInputStream(name)) {

            }catch (FileNotFoundException e){
                System.out.println(name);
                break;
       }
      }
    }
}
