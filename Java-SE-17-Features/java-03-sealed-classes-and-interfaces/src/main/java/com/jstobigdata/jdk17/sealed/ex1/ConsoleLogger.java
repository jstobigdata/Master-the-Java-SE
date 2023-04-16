package com.jstobigdata.jdk17.sealed.ex1;

public final class ConsoleLogger extends AppLogger {

    @Override
    public void log(String message, Object object){
        System.out.println(String.format(message, object));
    }
}
