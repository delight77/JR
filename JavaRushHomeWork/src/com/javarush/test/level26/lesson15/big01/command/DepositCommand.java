package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Locale;

/**
 * Created by GAVRISH on 25.04.16.
 */
class DepositCommand implements Command
{

    @Override
    public void execute() throws InterruptOperationException
    {
        Locale.setDefault(Locale.ENGLISH);
        String currencyCode = ConsoleHelper.askCurrencyCode();
        String[] ss = ConsoleHelper.getValidTwoDigits(currencyCode);

        CurrencyManipulator cm = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        cm.addAmount(Integer.parseInt(ss[0]),Integer.parseInt(ss[1]));

    }
}
