package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        int a[];
        a = new int[10];
        a[0] = Integer.parseInt(reader.readLine());
        a[1] = Integer.parseInt(reader.readLine());
        a[2] = Integer.parseInt(reader.readLine());
        a[3] = Integer.parseInt(reader.readLine());
        a[4] = Integer.parseInt(reader.readLine());


        for(int i = 5; i > 0; i--){
            for(int j = 0; j < 4; j++){
                if (a[j]> a[j+1]){
                    int mas = a[j];
                    a[j] = a[j+1];
                    a[j+1] = mas;
                }


            }
        }
        System.out.println(a[0]);
        System.out.println(a[1]);
        System.out.println(a[2]);
        System.out.println(a[3]);
        System.out.println(a[4]);
        //Напишите тут ваш код
    }
}
