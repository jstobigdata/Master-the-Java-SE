package com.jstobigdata.jdk17.records.ex3;

public class RecordBuilderExample {
    public static void main(String[] args) {
        Discount discount1 =  Discount.builder()
                .id(11L)
                .discountPercentage(10.00)
                .productId(22L)
                .productName("Apple Watch")
                .categoryName("Smart Watches")
                .categoryId(12L)
                .build();

        System.out.println(discount1);
    }
}
