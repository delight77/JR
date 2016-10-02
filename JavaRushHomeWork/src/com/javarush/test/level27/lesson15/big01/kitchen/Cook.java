package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by GAVRISH on 03.05.16.
 */
public class Cook extends Observable implements Observer
{
    String name;
    public Cook(String name){
        this.name = name;
    }

    @Override
    public String toString()
    {
        return this.name;
    }

    @Override
    public void update(Observable o, Object arg)
    {
        Order order = (Order) arg;
        ConsoleHelper.writeMessage("Start cooking - " + order + ", cooking time "+ ((Order) arg).getTotalCookingTime() +"min");
        setChanged();
        notifyObservers(order);

    }
}
