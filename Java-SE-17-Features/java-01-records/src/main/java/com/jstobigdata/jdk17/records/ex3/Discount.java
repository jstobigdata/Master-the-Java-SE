package com.jstobigdata.jdk17.records.ex3;

import com.jstobigdata.jdk17.records.ex1.ProductCategoryR;
import com.jstobigdata.jdk17.records.ex2.Product;

// Discount applied to a product or the entire category
public record Discount(long id, double discountPercentage, Product product, ProductCategoryR category) {

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private long id = 0L;
        private double discountPercentage;
        private long productId;
        private long categoryId;
        private String productName;
        private String categoryName;
        private String categoryDescription;


        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder discountPercentage(double discountPercentage) {
            this.discountPercentage = discountPercentage;
            return this;
        }

        public Builder productId(long productId) {
            this.productId = productId;
            return this;
        }

        public Builder categoryId(long categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        public Builder productName(String productName) {
            this.productName = productName;
            return this;
        }

        public Builder categoryName(String categoryName) {
            this.categoryName = categoryName;
            return this;
        }

        public Builder categoryDescription(String categoryDescription) {
            this.categoryDescription = categoryDescription;
            return this;
        }

        public Discount build(){
            ProductCategoryR pCategory = new ProductCategoryR(categoryId, categoryName, categoryDescription);
            Product product = new Product(productId, productName, pCategory);
            return new Discount(id, discountPercentage, product, pCategory);
        }
    }
}
