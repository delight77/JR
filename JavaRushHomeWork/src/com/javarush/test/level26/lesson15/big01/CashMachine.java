package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.command.CommandExecutor;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.IOException;
import java.util.Locale;

/**
 * Created by gavrish on 19.04.16.
 */
public class CashMachine
{
    public static void main(String[] args) throws IOException, InterruptOperationException
    {

        try{
        Locale.setDefault(Locale.ENGLISH);
        Operation operation;
        do
        {
            operation = ConsoleHelper.askOperation();
            CommandExecutor.execute(operation);
        }
        while (!operation.equals(Operation.EXIT));
        }
        catch (InterruptOperationException e){

            try {
                CommandExecutor.execute(Operation.EXIT);
            } catch (InterruptOperationException ignored) {
            }
            ConsoleHelper.writeMessage("Goodbye");

        }


    }
}
