package com.javarush.test.level04.lesson06.task01;

/* Минимум двух чисел
Ввести с клавиатуры два числа, и вывести на экран минимальное из них.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //Напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
        int aa = Integer.parseInt(a);
        String b = reader.readLine();
        int bb = Integer.parseInt(b);
        if (aa > bb)
            System.out.println(bb);
        else
            System.out.println(aa);
    }
}