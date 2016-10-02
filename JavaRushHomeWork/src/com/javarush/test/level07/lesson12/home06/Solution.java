package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        //Написать тут ваш код
        Human ded = new Human();
        ded.name = "Коля";
        ded.age = 68;
        ded.sex = true;

        Human ded1 = new Human();
        ded1.name = "Толя";
        ded1.age = 68;
        ded1.sex = true;

        Human baba = new Human();
        baba.name = "Света";
        baba.age = 66;
        baba.sex = false;

        Human baba1 = new Human();
        baba1.name = "Наташа";
        baba1.age = 67;
        baba1.sex = false;

        Human fath = new Human();
        fath.name = "Олег";
        fath.age = 40;
        fath.sex = true;
        fath.father = ded;
        fath.mother = baba;
        //fath.mother.name = baba.name;

        Human math = new Human();
        math.name = "Оля";
        math.age = 38;
        math.sex = false;
        math.father = ded1;
        math.mother = baba1;

        Human docha1 = new Human();
        docha1.name = "Галя";
        docha1.age = 18;
        docha1.sex = false;
        docha1.father = fath;
        docha1.mother = math;

        Human docha2 = new Human();
        docha2.name = "Га";
        docha2.age = 20;
        docha2.sex = false;
        docha2.father = fath;
        docha2.mother = math;

        Human docha3 = new Human();
        docha3.name = "Гал";
        docha3.age = 19;
        docha3.sex = false;
        docha3.father = fath;
        docha3.mother = math;

        System.out.println(ded.toString());
        System.out.println(baba.toString());
        System.out.println(ded1.toString());
        System.out.println(baba1.toString());
        System.out.println(fath.toString());
        System.out.println(math.toString());
        System.out.println(docha1.toString());
        System.out.println(docha2.toString());
        System.out.println(docha3.toString());
    }

    public static class Human
    {
        //Написать тут ваш код
        String name;
        int age;
        boolean sex;
        Human father;
        Human mother;

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
