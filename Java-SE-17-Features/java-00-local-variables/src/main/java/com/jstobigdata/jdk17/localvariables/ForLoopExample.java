package com.jstobigdata.jdk17.localvariables;

import java.util.List;

public class ForLoopExample {
    public static void varInForLoopExample(){
        //var arr = new int[]{1,2,3,4,5,6,7,8};
        int arr[] = new int[]{1,2,3,4,5,6,7,8};

        //Enhanced for-loop indexes
        System.out.println("======= var in foreach loop ========");
        for(var value: arr){
            System.out.println(value);
        }

        //Simple for-loop
        System.out.println("\n\n======= var in for loop ========");
        List<String> items = List.of("Fan", "AC", "Bulb", "Table");
        for (var i = 0; i < items.size(); i++) {
            var itemInCap = items.get(i).toUpperCase();
            System.out.println(itemInCap);
        }
    }

    public static void main(String[] args) {
        varInForLoopExample();
    }
}
