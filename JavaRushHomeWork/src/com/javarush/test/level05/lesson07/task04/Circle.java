package com.javarush.test.level05.lesson07.task04;

/**
 *JavaRush.ru
 *Level 05, Lesson 07, task 04
 *
 * Создать класс (Circle) круг, с тремя инициализаторами:
 *  - centerX, centerY, radius
 *  - centerX, centerY, radius, width
 *  - centerX, centerY, radius, width, color
 *
 * Date: 23.01.13
 * @author Sergey Kandalintsev
 */

public class Circle
{
    private int centerX;
    private int centerY;
    private int radius;
    private int width;
    private String color;

    public void initialize(int centerX, int centerY, int radius) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }
    public void initialize(int centerX, int centerY, int radius, int width) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.width = width;
    }
    public void initialize(int centerX, int centerY, int radius, int width, String color) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.width = width;
        this.color = color;
    }
}