package com.javarush.test.level15.lesson12.home04;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 19.11.14
 * Time: 9:57
 * To change this template use File | Settings | File Templates.
 */
public class Earth implements Planet
{
    private static Earth instance;

    private Earth(){}

    public static Earth getInstance(){
        if(instance == null){
            instance = new Earth();
        }
        return instance;
    }

}