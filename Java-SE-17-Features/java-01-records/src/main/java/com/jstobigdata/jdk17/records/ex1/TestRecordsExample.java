package com.jstobigdata.jdk17.records.ex1;

public class TestRecordsExample {
    public static void main(String[] args) {
        //Example-1
        ProductCategoryR productCategory1 = new ProductCategoryR(123L, "Formal Wears", "Generic category for Men's formal Wears");
        System.out.println(productCategory1.id());
        System.out.println(productCategory1.name());
        System.out.println(productCategory1.description());

        System.out.println(productCategory1);
    }
}
