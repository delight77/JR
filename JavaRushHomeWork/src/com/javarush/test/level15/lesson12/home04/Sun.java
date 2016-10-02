package com.javarush.test.level15.lesson12.home04;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 19.11.14
 * Time: 9:45
 * To change this template use File | Settings | File Templates.
 */
public class Sun  implements Planet
{
    private static Sun instance;

    private Sun(){}

    public static Sun getInstance(){
        if(instance == null){
            instance = new Sun();
        }
        return instance;
    }
}