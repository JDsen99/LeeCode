package com.ss.demo;

import java.io.File;
import java.util.Scanner;

/**
 * @author Senn
 * @date 2023/1/14 14:11
 */
public class TryDemo {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new File("files/1.txt"))) {
            System.out.println(sc.nextLine());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
