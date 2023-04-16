package com.jstobigdata.jdk17.localvariables;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TryResourceExample {
    public static void main(String[] args) {
        //Create a file
        try (var file = new FileOutputStream("hello.txt")){
            byte content[] = "This is a sample text".getBytes();
            file.write(content);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (var file = new FileInputStream("hello.txt")){
            int content;
            while((content = file.read()) != -1){
                System.out.print((char)content);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
