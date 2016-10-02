package com.javarush.test.level05.lesson12.home03;

/**
 * JavaRush.ru
 * Level 05, Lesson 12, home 03
 * <p/>
 * Создай классы Cat, Dog, Mouse. Добавь по три поля в каждый класс, на твой выбор. Создай объекты для героев
 * мультика Том и Джери. Так много как только вспомнишь.
 * Пример: Mouse jerryMouse = new Mouse("Jerry", 12 , 5) (имя, высота, длина хвоста)
 * <p/>
 * Date: 25.01.13
 * @author Sergey Kandalintsev
 */
public class Solution
{
    public static void main( String[] args )
    {
        Mouse jerryMouse = new Mouse( "Jerry", 12, 5 );
        Cat tomCat = new Cat( "Thomas \"Tom\" Cat Jasper", 30, 5 );
        Cat toodles = new Cat( "Toodles", 23, 3 );
        Dog spike = new Dog( "Spike", 4, 15 );
    }

    public static class Mouse
    {
        String name;
        int height;
        int tail;

        public Mouse( String name, int height, int tail )
        {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }

    public static class Dog
    {
        String name;
        int age;
        int weight;

        public Dog( String name, int age, int weight )
        {
            this.name = name;
            this.age = age;
            this.weight = weight;
        }
    }

    public static class Cat
    {
        String name;
        int height;
        int weight;

        public Cat( String name, int height, int weight )
        {
            this.name = name;
            this.height = height;
            this.weight = weight;
        }
    }
}