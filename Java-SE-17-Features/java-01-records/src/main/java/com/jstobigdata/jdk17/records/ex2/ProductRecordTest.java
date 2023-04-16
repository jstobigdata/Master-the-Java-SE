package com.jstobigdata.jdk17.records.ex2;

import com.jstobigdata.jdk17.records.ex1.ProductCategoryR;

public class ProductRecordTest {
    public static void main(String[] args) {
        //Example-1
        ProductCategoryR productCategory1 = new ProductCategoryR(123L, "Formal Wears", "Generic category for Men's formal Wears");
        System.out.println(productCategory1.id());
        System.out.println(productCategory1.name());
        System.out.println(productCategory1.description());

        System.out.println(productCategory1);


        //Example-2
        Product product1 = new Product(11L, "White Shirt", productCategory1);
        product1.print();

        //Example-3
        Product product2 = new Product(12L, null, null);
        product2.print();
    }
}
