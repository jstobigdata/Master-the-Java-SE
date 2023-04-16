package com.jstobigdata.jdk17.localvariables;

//applying the var identifier to each formal parameter in an implicitly typed lambda expression has the same effect as not using var at all
public class LambdaExamples {

    @FunctionalInterface
    private interface Sum {
        public int sum (int a , int b);
    }

    //Ideally
    public static Sum LambdaSumUtil = (a, b) -> a + b;

    //Legal - no added advantage
    public static Sum MathUtil = (var a, var b) -> a + b;

    //Illegal declarations
    //public Sum sum3 = (int a, var b) -> a + b;
    //public Sum sum4 = (var a, b) -> a + b;

    public static void main(String[] args) {
        System.out.println(LambdaSumUtil.sum(3,5));
        System.out.println(MathUtil.sum(3,4));
    }
}
