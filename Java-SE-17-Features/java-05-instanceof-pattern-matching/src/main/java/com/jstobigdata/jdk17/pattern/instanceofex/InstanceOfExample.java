package com.jstobigdata.jdk17.pattern.instanceofex;


//TODO - change the java version to 11 in pom.xml and see if this code works
public class InstanceOfExample{

    public String stringConcatJDK11(Object a, Object b){
        if(a instanceof Number) {
            Number n1 = (Number) a;
            return n1.toString() + b.toString();
        } else if (a instanceof String s){
            return s + b;
        }
        else throw new IllegalArgumentException("Can not convert to String");
    }

    public String stringConcat(Object a, Object b){
        if(a instanceof Number n1) {
           return n1.toString() + b.toString();
        } else if (a instanceof String s){
            return s + b;
        }
        else throw new IllegalArgumentException("Can not convert to String");
    }

    public static void main(String[] args) {
        InstanceOfExample example = new InstanceOfExample();

        String str1 = example.stringConcat(23, 45);
        String str2 = example.stringConcat(23, "45");
        String str3 = example.stringConcat("23", 45);

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
    }
}
