package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //Напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());

        if (a > b && b > c){
            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
        }
        if (a > c && c > b){
            System.out.println(a);
            System.out.println(c);
            System.out.println(b);
        }
        if (b > a && a > c){
            System.out.println(b);
            System.out.println(a);
            System.out.println(c);
        }
        if (b > c && c > a){
            System.out.println(b);
            System.out.println(c);
            System.out.println(a);
        }
        if (c > a && a > b){
            System.out.println(c);
            System.out.println(a);
            System.out.println(b);
        }
        if (c > b && b > a){
            System.out.println(c);
            System.out.println(b);
            System.out.println(a);
        }

    }
}
