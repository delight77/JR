package com.javarush.test.level05.lesson07.task05;

public class Rectangle
{
    int top, left, width, height;

    public void initialize(int top, int left, int width, int height){
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = height;
    }
    public void initialize(int top, int left){
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = height;
    }
    public void initialize(int top, int left, int width){
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = width;
    }
    public void initialize(Rectangle rectangle){
        this.top = rectangle.top;
        this.left = rectangle.left;
        this.width = rectangle.width;
        this.height = rectangle.width;
    }
}
