package com.trakos_project.menu.impl;
import com.trakos_project.enteties.User;
import com.trakos_project.menu.Menu;
import com.trakos_project.configs.ApplicationContext;
import com.trakos_project.services.UserManagementService;
import com.trakos_project.services.impl.DefaultUserManagementService;

public class CustomerListMenu implements Menu {

    private ApplicationContext context;
    private UserManagementService userManagementService;

    {
        userManagementService = DefaultUserManagementService.getInstance();
        context = ApplicationContext.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();
        User[] users=userManagementService.getUsers();
        if(users.length==0) {
            System.out.println("Unfortunately, there are no customers.");
        }else{
            for(User user : users){
                System.out.println(user);
            }

        }
        context.getMainMenu().start();
    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** USERS *****");
    }

}
