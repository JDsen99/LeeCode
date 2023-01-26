package com.ss.interview.meituan;

/**
 * @author Senn
 * @date 2023/1/14 16:00
 */
public class T1_01_14 {
    public static void main(String[] args) {
        String str = "false and true or true and false or true and true";

        String[] ors = str.split("or");
        for (String or : ors) {
            String trim = or.trim();
            if (trim.equals("true")) {
                System.out.println(true);
            }
            if (trim.contains("false")) {
                continue;
            } else {
                System.out.println(true);
                return;
            }
        }
        System.out.println(false);

    }
}
