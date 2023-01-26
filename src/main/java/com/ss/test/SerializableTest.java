package com.ss.test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Senn
 * @create 2022/3/24 11:20
 */
public class SerializableTest {
    public static void main(String[] args) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\object.out"));
            HashMap<String, Object> map = new HashMap<>();
            map.put("1", 123123);
            oos.writeObject(map);
            ObjectInputStream ois= new ObjectInputStream(new FileInputStream("D:\\object.out"));
            Map<String, Object> map1 = (Map<String, Object>) ois.readObject();
            Object o = map1.get("1");
            System.out.println(o);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
