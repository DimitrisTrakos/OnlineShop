package com.trakos_project.services;
import com.trakos_project.enteties.User;
public interface UserManagementService {

    String registerUser(User user);

    User[] getUsers();

    User getUserByEmail(String userEmail);

}
