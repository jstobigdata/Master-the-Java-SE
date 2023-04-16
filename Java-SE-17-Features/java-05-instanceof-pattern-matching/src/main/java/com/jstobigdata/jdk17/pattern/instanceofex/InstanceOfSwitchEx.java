package com.jstobigdata.jdk17.pattern.instanceofex;

import java.util.Scanner;

//JDK-17 preview feature
//TODO - Check the pom.xml
public class InstanceOfSwitchEx {

    public Object repeat(Object digit, int count) {
        return switch(digit) {
            case Character c -> {
                System.out.println("Char detected: ");
                yield c.toString().repeat(count);
            }
            case String s -> {
                System.out.println("String detected: ");
                yield s.repeat(count);
            }
            case Number n -> {
                System.out.println("Number detected: ");
                yield n.toString().repeat(count);
            }

            default -> throw new IllegalArgumentException("Invalid Param:");
        };
    }

    public static void main(String[] args) {
        //Draw any pattern
        InstanceOfSwitchEx ex = new InstanceOfSwitchEx();
        System.out.println(ex.repeat(123,20));
        System.out.println(ex.repeat("123",20));
        System.out.println(ex.repeat('1',20));
    }


}
