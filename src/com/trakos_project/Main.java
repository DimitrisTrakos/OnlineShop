package com.trakos_project;

import com.trakos_project.menu.Menu;
import com.trakos_project.menu.impl.MainMenu;

public class Main {

    public static final String EXIT_COMMAND = "exit";

    public static void main(String[] args) {
        Menu mainMenu = new MainMenu();
        mainMenu.start();
    }

}

