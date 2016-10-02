package com.javarush.test.level12.lesson12.home10;

/**
 * JavaRush.ru
 * Level 12, Lesson 12, Home 10
 * <p/>
 * Добавь еще один метод чтобы программа выводила на экран число 10. Используй перегрузку методов.
 * <p/>
 * Date: 28.04.13
 * @author Sergey Kandalintsev
 */
public class Solution
{
    public static void main( String[] args )
    {
        Integer i = 5;
        int x = transformValue( i );

        System.out.println( x );
    }

    public static int transformValue( int i )
    {
        return i * i;
    }

    public static int transformValue( Integer i )
    {
        return i * 2;
    }
}