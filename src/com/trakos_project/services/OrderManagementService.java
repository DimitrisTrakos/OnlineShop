package com.trakos_project.services;
import com.trakos_project.enteties.Order;

public interface OrderManagementService {

    void addOrder(Order order);

    Order[] getOrdersByUserId(int userId);

    Order[] getOrders();

}