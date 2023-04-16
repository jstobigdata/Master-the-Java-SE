package com.jstobigdata.jdk17.sealed.ex1;

import java.io.FileWriter;
import java.io.IOException;

public non-sealed class FileLogger extends AppLogger {
    private final String logFile = "log.txt";

    @Override
    public void log(String message, Object object){
        try(var file = new FileWriter(logFile, true)){
            System.out.println(String.format(message, object));
            file.write(String.format(message, object));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
