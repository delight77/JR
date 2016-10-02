package com.javarush.test.level06.lesson11.home01;

public class Solution
{
    public static void main(String[] args)
    {
        for (int i = 0; i < 10; i++)
        {
            new Cat();
        }

        System.out.println(Cat.catCount);
    }

    public static class Cat
    {
        static int catCount;

        public Cat()
        {
            catCount++;
        }
    }

}
