package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {

    public static String getPartOfString(String string) throws TooShortStringException
    {
        if (string == null)
            throw new TooShortStringException();
        if (string.equals(""))
            throw new TooShortStringException();
        int b = 0;
        int g = 0;
        int c = 0;
        for(int i=0;i<string.length();i++){
            char n = string.charAt(i);
            if(n == ' '){
                g = i;
                break;
            }
        }
        for(int i=0;i<string.length();i++){

            char n = string.charAt(i);
            if(n == ' '){
                b++;
            }
            if(b==5){
                c = i;
                break;
            }
        }
        String s = string.substring(g,c);
        return s;

    }

    public static class TooShortStringException extends Exception{
    }

    public static void main (String[] args) throws TooShortStringException
    {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }
}
