package com.javarush.task.task17.task1721;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();
    private static String f1;
    private static String f2;

    public static void main(String[] args) {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        try {
            f1 = br.readLine();
            f2 = br.readLine();
            br.close();

        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла");
        }


        try {
            BufferedReader fr1 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(f1))));
            String line1;

            while((line1 = fr1.readLine()) != null){
                allLines.add(line1);
            }
            fr1.close();
            BufferedReader fr2 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(f2))));
            String line2;
            while((line2 = fr2.readLine()) != null){
                forRemoveLines.add(line2);
            }
            fr2.close();
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла");
        }


        try {
            Solution s = new Solution();
            s.joinData();
        } catch (Exception e){}



    }

    public  void joinData () throws CorruptedDataException {
        for (int i = 0; i < forRemoveLines.size(); i++) {
            if (allLines.contains(forRemoveLines.get(i))) {
                allLines.remove(forRemoveLines.get(i));
            } else {
                allLines.clear();
                throw new CorruptedDataException();
            }
        }
    }  }