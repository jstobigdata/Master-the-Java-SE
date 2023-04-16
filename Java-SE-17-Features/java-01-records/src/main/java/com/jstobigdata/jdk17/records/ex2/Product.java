package com.jstobigdata.jdk17.records.ex2;

import com.jstobigdata.jdk17.records.ex1.ProductCategoryR;

import java.util.Objects;

/*Read only Product Data
TODO - Override the necessary methods - accessors, constructors, hashcode and equals.
TODO - 1. Replace the Canonical Constructor with Compact Constructor
TODO - 2. Remove the the public visibility and see.
 */
public record Product(long id, String name, ProductCategoryR category) {

    //You can not remove public keyword.
    public Product(long id, String name, ProductCategoryR category){
        if(name == null || category == null){
            throw new IllegalArgumentException(
                String.format("Invalid parameters: name = %s, category = %s", id, name)) ;
        }
        this.id = id;
        this.name = name;
        this.category = category;
    }

    //Compact Constructor over canonical Constructor
    /*public Product{
        if(name == null || category == null){
            throw new IllegalArgumentException(String.format("Invalid parameters: name = %s, category = %s", id, name)) ;
        }
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product that = (Product) o;
        return id == that.id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category);
    }

    public void print() {
        System.out.println(this);
    }
}
