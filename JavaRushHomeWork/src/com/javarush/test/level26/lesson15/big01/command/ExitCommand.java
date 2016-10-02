package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by GAVRISH on 25.04.16.
 */
class ExitCommand implements Command
{
    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage("You sure want to exit <y,n>");
        String q = ConsoleHelper.readString();
        if(q.equals("y")){
            ConsoleHelper.writeMessage("Goodbye");
        }
    }
}
