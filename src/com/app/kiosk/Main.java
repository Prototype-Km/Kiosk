package com.app.kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {


        List<MenuItem> burgers = new ArrayList<>();
        burgers.add(new MenuItem("CheeseBurger",7.6,"햄버거 먹고싶다. 치즈버거 먹으러가자"));
        burgers.add(new MenuItem("HamBugee",5.0,"그 유명한 햄부기"));
        burgers.add(new MenuItem("ChickenBurger",8.4,"치킨 goat부기"));
        burgers.add(new MenuItem("ShackBurger",6.9,"토마토,양상추, 쉑소스가 토핑된 쉑 버거"));

        List<MenuItem> drinks = new ArrayList<>();
        drinks.add(new MenuItem("Ice Americano", 5.0, "죽어도 얼죽아"));
        drinks.add(new MenuItem("choco Latte",7.0,"초코라떼는 맛있다"));
        drinks.add(new MenuItem("Mint Tea",6.0,"시원한 민트 차"));
        drinks.add(new MenuItem("Orange juice",6.0,"오렌지 주스 "));

        Menu menuHamburgers = new Menu("HAMBURGERS",burgers);
        Menu menuDrinks = new Menu("DRINKS",drinks);
        List<Menu> mainMenu = new ArrayList<>();
        mainMenu.add(menuHamburgers);
        mainMenu.add(menuDrinks);

        Kiosk kiosk = new Kiosk(mainMenu);
        kiosk.start();

    }



}
