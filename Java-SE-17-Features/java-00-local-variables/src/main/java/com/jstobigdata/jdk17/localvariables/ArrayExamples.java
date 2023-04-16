package com.jstobigdata.jdk17.localvariables;

import java.util.Arrays;

public class ArrayExamples {

    public static void arrayExample1(){
        int [] arr = new int[5];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[4] = 4;
        System.out.println("======= Normal Array ========");
        Arrays.stream(arr).forEach(System.out::println);

        //Now using var
        //TODO - uncomment the below line
        //var [] varArr = new int[5];
        var varArr = new int[5];
        varArr[0] = 11;
        varArr[1] = 22;
        varArr[2] = 33;
        varArr[4] = 44;
        System.out.println("\n======== var array ======");
        Arrays.stream(varArr).forEach(System.out::println);
    }


    public static void arrayExample2(){
        int [] arr = {0,1,2,3,4};
        System.out.println("\n\n======= Eaxmple-2 ========");
        Arrays.stream(arr).forEach(System.out::println);

        //Uncomment and see
        //var varArr = {0, 1, 2, 3, 4};
        var varArr = new int[] {0, 1, 2, 3, 4};
        System.out.println("\n======== var array ======");
        Arrays.stream(varArr).forEach(System.out::println);
    }

    public static void main(String[] args) {
        arrayExample1();
        arrayExample2();
    }
}
