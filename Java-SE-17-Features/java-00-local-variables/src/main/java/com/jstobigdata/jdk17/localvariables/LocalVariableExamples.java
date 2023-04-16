package com.jstobigdata.jdk17.localvariables;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LocalVariableExamples {
    //private static var id = 101;

    public static void localVarExample1(){
        //example-1
        String name = "John Doe";
        System.out.println("name: " + name);

        int num = 4565;
        System.out.println(num);

        //example of var
        var num2 = 1234;
        var name2 = "Rakesh Roshan";
        System.out.println("\n\n===== Using var ======");
        System.out.println(num2);
        System.out.println(name2);

        System.out.println(name2.getClass());
        //System.out.println(num2.); - Understand why you can not
    }

    public static void useWithList(){
        var varList = new LinkedList<Integer>();
        varList.add(1);
        varList.add(5);
        System.out.println(varList);
        System.out.println(varList.getClass());

        List<Integer> ls = new ArrayList<>();
        System.out.println(ls instanceof List);

        //can not use instanceof on var
        /*if (varList instanceof ArrayList){
            System.out.println();
        }*/

    }


    public static void main(String[] args) {
        localVarExample1();
        useWithList();
    }
}
