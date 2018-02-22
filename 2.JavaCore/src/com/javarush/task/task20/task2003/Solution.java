package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(br.readLine());
        load(fis);
    }

    public void save(OutputStream outputStream) throws Exception {
        Properties prop = new Properties();
        for (Map.Entry<String, String> map :properties.entrySet()) {
            prop.setProperty(map.getKey(),map.getValue());
        }
        prop.store(outputStream,"");

    }

    public void load(InputStream inputStream) throws Exception {
        Properties prop = new Properties();
        prop.load(inputStream);
        for (Map.Entry<Object, Object> map :prop.entrySet()) {
            properties.put(map.getKey().toString(),map.getValue().toString());
        }


    }

    public static void main(String[] args) {

    }
}
