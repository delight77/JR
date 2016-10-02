package com.javarush.test.level27.lesson15.big01.ad;

/**
 * Created by GAVRISH on 05.05.16.
 */
public class Advertisement
{
    private Object content;
    private String name;
    private long initialAmount;
    private int hits;
    private int duration;
    private long amountPerOneDisplaying;

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration)
    {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        this.amountPerOneDisplaying = initialAmount/hits;
    }

    public String getName(){
        return  this.name;
    }
    public int getDuration(){
        return this.duration;
    }
    public long getAmountPerOneDisplaying(){
        return this.amountPerOneDisplaying;
    }
}
