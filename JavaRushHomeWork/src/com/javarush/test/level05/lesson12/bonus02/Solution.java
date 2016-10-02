package com.javarush.test.level05.lesson12.bonus02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Нужно добавить в программу новую функциональность
Задача: Программа вводит два числа с клавиатуры и выводит минимальное из них на экран.
Новая задача: Программа вводит пять чисел с клавиатуры и выводит минимальное из них на экран.
*/

public class Solution
{

    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        int d = Integer.parseInt(reader.readLine());
        int e = Integer.parseInt(reader.readLine());

        int minimum = min(a, b, c, d, e);

        System.out.println("Minimum = " + minimum);
    }


    public static int min(int a, int b, int c, int d, int e)
    {
       int r[] = new int[5];
       r[0] = a;
       r[1] = b;
       r[2] = c;
       r[3] = d;
       r[4] = e;
        int g = 0;
       for(int i = 0; i < 5; i++){
           for(int j = i+1; j < 5; j++){
               if(r[i] < r[j]){
                  g = r[i];
                  r[i] = r[j];
                  r[j] = g;
               }
           }
       }
        return r[4];

    }

}
