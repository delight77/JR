package com.javarush.test.level23.lesson13.big01;

import java.util.ArrayList;

/**
 * Created by gavrish on 17.03.16.
 */
public class Snake
{
    private SnakeDirection direction;
    private boolean isAlive;
    private ArrayList<SnakeSection> sections = new ArrayList<SnakeSection>();
    int x;
    int y;

    public Snake(int x,int y){
        this.x = x;
        this.y = y;
        sections.add(new SnakeSection(x,y));
        isAlive = true;
    }
    public ArrayList<SnakeSection> getSections()
    {
        return sections;
    }

    public boolean isAlive()
    {
        return isAlive;
    }

    public SnakeDirection getDirection()
    {
        return direction;
    }

    public void setDirection(SnakeDirection direction)
    {
        this.direction = direction;
    }

    public int getX()
    {
        return sections.get(0).getX();
    }

    public int getY()
    {
        return sections.get(0).getY();
    }

    public void move(){

    }


}
