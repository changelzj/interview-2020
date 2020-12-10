package com.example;

public class TestStringPool {
    public static void main(String[] args) {
        String str1 = new StringBuffer("ali").append("baba").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuffer("ja").append("va").toString();
        System.out.println(str2.intern() == str2);

    }
}
