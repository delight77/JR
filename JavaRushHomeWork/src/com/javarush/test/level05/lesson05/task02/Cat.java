package com.javarush.test.level05.lesson05.task02;

/* Реализовать метод fight
Реализовать метод boolean fight(Cat anotherCat):
реализовать механизм драки котов в зависимости от их веса, возраста и силы.
Зависимость придумать самому. Метод должен определять, выиграли ли мы (this) бой или нет,
т.е. возвращать true, если выиграли и false - если нет.
Должно выполняться условие:
если cat1.fight(cat2) = true , то cat2.fight(cat1) = false
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Cat {
    public String name;
    public int age;
    public int weight;
    public int strength;

    public Cat()
    {
    }

    public boolean fight (Cat anotherCat)
    {
        //Напишите тут ваш код
        if(age > anotherCat.age && weight > anotherCat.weight && strength > anotherCat.strength){
            return true;
        }
        else return false;
    }
    public static void main(String[] args) throws Exception
    {
        //Напишите тут ваш код
        Cat cat1 = new Cat();
        cat1.name = "Vasya";
        cat1.age = 2;
        cat1.weight = 15;
        cat1.strength = 20;

        Cat cat2 = new Cat();
        cat2.name = "Barsik";
        cat2.age = 1;
        cat2.weight = 10;
        cat2.strength = 15;

        cat1.fight(cat2);

    }
}
