package com.javarush.task.task22.task2208;

import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
      /*  Map<String, String> map = new TreeMap<>();
        map.put("name","Ivanov");
        map.put("country","Ukraine");
        map.put("city","Kiev");
        map.put("age",null);

        System.out.println(getQuery(map));
*/

    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry m:params.entrySet()) {
             if (m.getValue()==null)continue;
             if (sb.length()==0) sb.append(String.format("%s = '%s'", m.getKey(), m.getValue()));
             else sb.append(String.format(" and %s = '%s'",m.getKey(), m.getValue()));
        }
        return sb.toString();
    }
}
