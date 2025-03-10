package com.app.kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    //실행 시 햄버거 메뉴 표시, 이후 Scanner 숫자 입력받고 메뉴 선택
    // 제시된 메뉴중 입력받은 숫자에 따른 로직 실행 코드 작성
    // 반복문 이용 -> 특정번호 입력되면 프로그램 종료

    public static void main(String[] args) {

        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("CheeseBurger",7.6,"햄버거 먹고싶다. 치즈버거 먹으러가자"));
        menuItems.add(new MenuItem("HamBugee",5.0,"그 유명한 햄부기"));
        menuItems.add(new MenuItem("ChickenBurger",8.4,"치킨 goat부기"));
        menuItems.add(new MenuItem("ShackBurger",6.9,"토마토,양상추, 쉑소스가 토핑된 쉑 버거"));

        Kiosk kiosk = new Kiosk(menuItems);
        kiosk.start();



    }
}
