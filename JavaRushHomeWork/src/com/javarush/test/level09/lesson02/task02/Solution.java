package com.javarush.test.level09.lesson02.task02;

/* И снова StackTrace
Написать пять методов, которые вызывают друг друга. Каждый метод должен возвращать имя метода, вызвавшего его, полученное с помощью StackTrace.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {

    }

    public static String method1()
    {
        method2();
        StackTraceElement[] l = Thread.currentThread().getStackTrace();
        String q = l[2].getMethodName();
        System.out.println(q);
        return q;
    }

    public static String method2()
    {
        method3();
        StackTraceElement[] l = Thread.currentThread().getStackTrace();
        String q = l[2].getMethodName();
        System.out.println(q);
        return q;

    }

    public static String method3()
    {
        method4();
        StackTraceElement[] l = Thread.currentThread().getStackTrace();
        String q = l[2].getMethodName();
        System.out.println(q);
        return q;


    }

    public static String method4()
    {
        method5();
        StackTraceElement[] l = Thread.currentThread().getStackTrace();
        String q = l[2].getMethodName();
        System.out.println(q);
        return q;

    }

    public static String method5()
    {
        StackTraceElement[] l = Thread.currentThread().getStackTrace();
        String q = l[2].getMethodName();
        System.out.println(q);
        return q;

    }
}
