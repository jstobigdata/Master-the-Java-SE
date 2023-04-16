package com.jstobigdata.jdk17.sealed.ex1;

public sealed class AppLogger permits ConsoleLogger, FileLogger {

    public void log(String message, Object object){
        System.out.println(String.format(message, object));
    }
}
