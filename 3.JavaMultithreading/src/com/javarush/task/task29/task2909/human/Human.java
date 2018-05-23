package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Human implements Alive{
    //Fields
    private static int nextId = 0;
    private int id;
    protected int age;
    protected String name;
    private List<Human> children = new ArrayList<>();
    protected Size size;
    private BloodGroup bloodGroup;

    // Constructors
    public Human() { }
    public Human(boolean isSoldier) {
        this.id = nextId;
        nextId++;
    }
    public Human(String name, int age) {
        this.age = age;
        this.name = name;
    }


    //Setters/Getters
    public void setBloodGroup(BloodGroup bg) {
    bloodGroup=bg;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<Human> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public String getPosition(){return "Человек";}

    public int getId() {
        return id;
    }


    //Methods
    public void live() {}
    public void printSize() {
        System.out.println("Рост: " + size.height + " Вес: " + size.weight);
    }
    public void addChild(Human human){
        children.add(human);
    }
    public void removeChild(Human human){
        children.remove(human);
    }
    public void printData() {
        System.out.println(getPosition()+": " + name);
    }

    //Inner class
    public class Size{
        public Size() {
        }
        public Size(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        public int height;
        public int weight;
    }

}