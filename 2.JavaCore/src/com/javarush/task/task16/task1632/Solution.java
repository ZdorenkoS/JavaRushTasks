package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Potok1());
        threads.add(new Potok2());
        threads.add(new Potok3());
        threads.add(new Potok4());
        threads.add(new Potok5());
    }

    public static void main(String[] args) {
    }

    public static class Potok1 extends  Thread{

        @Override
        public void run() {
            while (true){}
        }
    }

    public static class Potok2 extends  Thread{

        @Override
        public void run() {
          try {Thread.sleep(1);
          }catch (InterruptedException e) {
              System.out.println("InterruptedException");
          }
        }
    }

    public static class Potok3 extends  Thread{

        @Override
        public void run() {
            while (true){
                System.out.println("Ура");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class Potok4 extends  Thread implements Message{

        @Override
        public void run() {
            while (true){}
        }

        @Override
        public void showWarning() {
            Thread.currentThread().interrupt();
        }
    }

    public static class Potok5 extends  Thread{

        @Override
        public void run() {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = "";
            int i=0;
            try {
            while (!(s=br.readLine()).equals("N")){
                i+=Integer.parseInt(s);
            }
            br.close();
            } catch (IOException e) {e.printStackTrace();}
            System.out.println(i);
        }
    }

}