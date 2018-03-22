package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    public static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    void run() throws InterruptedException {
        for (int i = 0; i <100 ; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }
    void move(){
        for (Horse h:horses) {
            h.move();
        }
    }
    void print(){
        for (Horse h : horses) {
            h.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner(){
       double dist=0;
       Horse horse = null;
        for (Horse h : horses) {
            if (h.distance > dist) {
                dist = h.distance;
                horse = h;
            }
        }   return horse;
    }

    public void printWinner(){
        System.out.println("Winner is "+getWinner().name+"!");
    }

    
    public static void main(String[] args) throws InterruptedException {

        Horse h1 = new Horse("konina",3,0);
        Horse h2 = new Horse("kon",3,0);
        Horse h3 = new Horse("kona",3,0);
        List<Horse> horses = new ArrayList<>();
        horses.add(h1);horses.add(h2);horses.add(h3);

        game=new Hippodrome(horses);
        game.run();
        game.printWinner();
    }
}
