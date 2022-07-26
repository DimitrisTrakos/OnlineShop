package com.trakos_project.enteties.impl;
import com.trakos_project.enteties.Cart;
import com.trakos_project.enteties.Product;

import java.lang.reflect.Array;
import java.util.Arrays;

public class DefaultCart implements Cart {
    private static final int DEFAULT_PRODUCT_CAPACITY=10;
    private Product[] products;
    private int lastindex;

    {
        products=new Product[DEFAULT_PRODUCT_CAPACITY];
    }

    @Override
    public boolean isEmpty() {
       if (products==null || products.length==0){
           return true;
       }
       for( Product product: products){
           if(product !=null){
               return false;
           }
       }
        return true;
    }

    @Override
    public void addProduct(Product product) {
        if(products ==null){
            return;
        }
        if(products.length<=lastindex) {
            products = Arrays.copyOf(products, products.length << 1);
        }
        products[lastindex++]=product;
    }

    @Override
    public Product[] getProducts() {
        int amountNoNullProducts=0;
        for (Product product: products){
            if(product !=null){
                amountNoNullProducts++;
            }
        }
         Product[] noNullProducts= new Product[amountNoNullProducts];
        int index=0;
        for(Product product: products){
            if(product !=null){
                noNullProducts[index++]=product;

            }
        }
        return noNullProducts;
    }

    @Override
    public void clear() {
        products= new Product[DEFAULT_PRODUCT_CAPACITY];
    }

}
