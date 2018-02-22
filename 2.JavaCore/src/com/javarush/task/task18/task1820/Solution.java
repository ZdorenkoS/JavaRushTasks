package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String f1 = br.readLine();
        String f2 = br.readLine();
        br.close();

        InputStream is = new FileInputStream(f1);
        OutputStream os = new FileOutputStream(f2);

        String s="";
        int oneByte;

        while (true){
            while ((oneByte = is.read())!=32){
                if (oneByte==13 || oneByte==-1)  break;
                s+=(char)oneByte;}
            if (!s.isEmpty()){
            os.write((Integer.toString((int) Math.round(Double.parseDouble(s)))+" ").getBytes());
             s="";}
            if (oneByte==-1) break;
        }

        is.close();
        os.flush();
        os.close();



    }
}
