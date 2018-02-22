package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file1 = br.readLine();
        String file2 = br.readLine();
        br.close();

        FileReader fr = new FileReader(file1);
        FileWriter fw = new FileWriter(file2);

        for (int i = 1 ;; i++){
           if (!fr.ready()) break;
            int j = fr.read();
            if (i%2==0) fw.write(j);
        }
        fr.close();
        fw.close();
    }
}
