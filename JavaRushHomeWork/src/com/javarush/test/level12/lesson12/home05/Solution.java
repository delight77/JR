package com.javarush.test.level12.lesson12.home05;

/**
 * JavaRush.ru
 * Level 12, Lesson 12, Home 05
 * <p/>
 * Напиши метод, который определяет, какой объект передали в него. Программа должна выводить на экран одну из надписей:
 * "Кот", "Тигр", "Лев", "Бык", "Корова", "Животное". Постарайся определять тип животного как можно более точно.
 * <p/>
 * Date: 27.04.13
 * @author Sergey Kandalintsev
 */
public class Solution
{
    public static void main( String[] args )
    {
        System.out.println( getObjectType( new Cat() ) );
        System.out.println( getObjectType( new Tiger() ) );
        System.out.println( getObjectType( new Lion() ) );
        System.out.println( getObjectType( new Bull() ) );
        System.out.println( getObjectType( new Cow() ) );
        System.out.println( getObjectType( new Animal() ) );
    }

    public static String getObjectType( Object o )
    {
        if ( o instanceof Tiger )
        {
            return "Тигр";
        }
        if ( o instanceof Lion )
        {
            return "Лев";
        }
        if ( o instanceof Cat )
        {
            return "Кот";
        }
        if ( o instanceof Bull )
        {
            return "Бык";
        }
        if ( o instanceof Cow )
        {
            return "Корова";
        }

        return "Животное";
    }

    public static class Cat extends Animal
    {
    }

    public static class Tiger extends Cat
    {
    }

    public static class Lion extends Cat
    {
    }

    public static class Bull extends Animal
    {
    }

    public static class Cow extends Animal
    {
    }

    public static class Animal
    {
    }
}