package com.app.kiosk;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.app.kiosk.Category.*;
import static com.app.kiosk.Category.DRINKS;


public class Main {
    public static void main(String[] args) {

        List<MenuItem> hamburgers = new ArrayList<>();
        hamburgers.add(new MenuItem("CheeseBurger",7.6,"햄버거 먹고싶다. 치즈버거 먹으러가자",HAMBURGERS));
        hamburgers.add(new MenuItem("HamBugee",5.0,"그 유명한 햄부기",HAMBURGERS));
        hamburgers.add(new MenuItem("ChickenBurger",8.4,"치킨 goat부기",HAMBURGERS));
        hamburgers.add(new MenuItem("ShackBurger",6.9,"토마토,양상추, 쉑소스가 토핑된 쉑 버거",HAMBURGERS));

        List<MenuItem> drinks = new ArrayList<>();

        drinks.add(new MenuItem("Ice Americano", 5.0, "죽어도 얼죽아",DRINKS));
        drinks.add(new MenuItem("choco Latte",7.0,"초코라떼는 맛있다",DRINKS));
        drinks.add(new MenuItem("Mint Tea",6.0,"시원한 민트 차",DRINKS));
        drinks.add(new MenuItem("Orange juice",6.0,"오렌지 주스 ",DRINKS));

        List<MenuItem> desserts = new ArrayList<>();

        desserts.add(new MenuItem("CheeseCake", 4.3,"달달한 치즈케잌은 맛있어",DESSERTS));
        desserts.add(new MenuItem("쿠엔크", 1.3,"초코는 쿠엔크지",DESSERTS));
        desserts.add(new MenuItem("요아정", 9.3,"요아정",DESSERTS));
        desserts.add(new MenuItem("피자빵", 3.3,"배고프다",DESSERTS));

        Menu burgerList = new Menu(HAMBURGERS);
        Menu drinkList = new Menu(DRINKS);
        Menu dessertList =new Menu(DESSERTS);

        for(MenuItem burger : hamburgers){
            burgerList.addMenuItem(burger);
        }
        for(MenuItem drink : drinks){
            drinkList.addMenuItem(drink);
        }
        for(MenuItem dessert : desserts){
            dessertList.addMenuItem(dessert);
        }

        List<Menu> mainMenu = new ArrayList<>();
        mainMenu.add(burgerList);
        mainMenu.add(drinkList);
        mainMenu.add(dessertList);

        Kiosk kiosk = new Kiosk(mainMenu);
        kiosk.start();

    }

}
