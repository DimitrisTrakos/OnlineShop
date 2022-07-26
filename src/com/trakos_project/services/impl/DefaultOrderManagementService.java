package com.trakos_project.services.impl;
import com.trakos_project.enteties.Order;
import com.trakos_project.services.OrderManagementService;

import java.util.Arrays;

public class DefaultOrderManagementService implements OrderManagementService {

    private static final int DEFAULT_ORDER_CAPACITY = 10;

    private static DefaultOrderManagementService instance;

    private int lastIndex=0;
    private Order[] orders;
    {
        orders= new Order[DEFAULT_ORDER_CAPACITY];
    }

    public static OrderManagementService getInstance() {
        if (instance == null) {
            instance = new DefaultOrderManagementService();
        }
        return instance;
    }

    @Override
    public void addOrder(Order order) {
        if(order== null){
            return;
        }
        if(orders.length<=lastIndex){
            orders= Arrays.copyOf(orders,orders.length<< 1);
        }
        orders[lastIndex++]=order;
    }

    @Override
    public Order[] getOrdersByUserId(int userId) {
        int amountofUserOrders=0;
        for(Order order: orders){
            if(order!=null && order.getCustomerId()==userId){
                amountofUserOrders++;
            }
        }
        Order[] userOrders =new Order[amountofUserOrders];
        int index =0;
        for(Order order: orders){
            if(order !=null && order.getCustomerId()==userId){
                userOrders[index++]= order;
            }
        }
        return userOrders;
    }

    @Override
    public Order[] getOrders() {
        int noNullOrdersAmount=0;
        for( Order order : orders){
            if( order != null){
                noNullOrdersAmount++;
            }
        }
        int index=0;
        Order[] noNullOrders= new Order[noNullOrdersAmount];

        for( Order order: orders){
            if( order !=null){
                noNullOrders[index++]=order;
            }
        }
        return noNullOrders;
    }

    void clearServiceState() {
        // <write your code here>
    }

}
