package com.ss.interview.t360;

import java.util.Scanner;

/**
 * @author Senn
 * @create 2022/3/19 15:07
 */
public class T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        boolean num = false;
        boolean up = false;
        boolean down = false;
        boolean sp = false;
        while(sc.hasNextLine()) {
            str = sc.nextLine();
            if (str.length() < 8) {
                System.out.println("Irregular password");
                continue;
            }

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) >=  65 && str.charAt(i) <= 90 ) down = true;
                else if (str.charAt(i) >=  97 && str.charAt(i) <= 122 ) up = true;
                else if (str.charAt(i) >=  48 && str.charAt(i) <= 57 ) num = true;
                else sp = true;
            }
            if (up && down && sp && num) System.out.println("Ok");
            else System.out.println("Irregular password");
            up = false;
            down = false;
            num = false;
            sp = false;
        }
    }
}
