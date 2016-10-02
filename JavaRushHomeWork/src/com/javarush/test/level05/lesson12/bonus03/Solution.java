package com.javarush.test.level05.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum = -2147483648;
        int  r1 = Integer.parseInt(reader.readLine());
        if (r1 > 0)
        {
            for (int r = r1; r > 0; r--)
            {   int t = Integer.parseInt(reader.readLine());
                maximum = Math.max(maximum, t);
            }
        }
        else
            System.out.println("Error");
        System.out.println(maximum);
    }

}
