package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name;
        while (!(name=br.readLine()).equals("exit")){
            new ReadThread(name).start();
        }
        br.close();
    }

    public static class ReadThread extends Thread {
        private  String fileName;

        public ReadThread(String fileName) {
           this.fileName = fileName;
        }

        @Override
        public void run() {
            int [] bayt = new int[256];
            try(FileInputStream is = new FileInputStream(fileName)){
                while (is.available()>0){
                   bayt[is.read()]++;
                }

                int max=0;
                int index=0;
                for (int i = 0; i <255 ; i++) {
                    if (bayt[i]>max) {max=bayt[i];index=i;}
                }
                resultMap.put(fileName,index);


            } catch (IOException e) {
                System.out.println("Ошибка при чтении файла "+ fileName);
            }
        }


    }
}
