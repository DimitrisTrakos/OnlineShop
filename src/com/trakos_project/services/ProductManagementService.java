package com.trakos_project.services;
import com.trakos_project.enteties.Product;
public interface ProductManagementService {

    Product[] getProducts();

    Product getProductById(int productIdToAddToCart);

}