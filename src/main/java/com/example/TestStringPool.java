package com.example;

public class TestStringPool {
    public static void main(String[] args) {
        // intern() 常量池已经包含字符串，直接从常量池返回，否则新建并添加到池然后返回引用
        //System类 加载时，在线程初始化后调用 initializeSystemClass() 然后sun.misc.Version.init();
        String str1 = new StringBuffer("ali").append("baba").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuffer("ja").append("va").toString();
        System.out.println(str2.intern() == str2);

    }
}
