package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.IOException;

/**
 * Created by GAVRISH on 25.04.16.
 */
interface Command
{
    public void execute() throws InterruptOperationException, IOException;
}
