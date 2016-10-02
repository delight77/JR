package com.javarush.test.level09.lesson02.task05;

/* Метод должен возвращать результат – глубину его стек-трейса
Написать метод, который возвращает результат – глубину его стек трейса – количество методов в нем (количество элементов в списке). Это же число метод должен выводить на экран.
*/

public class Solution
{
    public static int getStackTraceDeep()
    {
        //Напишите тут ваш код
        int i = 0;
        StackTraceElement [] l = Thread.currentThread().getStackTrace();
        for(StackTraceElement el:l){
           i = i + 1;
        }
        System.out.println(i);
        return i;
    }
}
