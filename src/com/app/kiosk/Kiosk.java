package com.app.kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//메뉴 관리, 사용자 입력 처리
// MenuItem관리하는 리스트가 필드로 존재
//start함수
//List<MenuItem> menuItems 는 Kiosk
public class Kiosk {

    private List<MenuItem> menuItems = new ArrayList<>();

    public Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }



    void start() {
        String message = "[ K RESTAURANT MENU ] ";
        String line = ("-----------------------------------------------------------");
        String messagePrint = "0.  종료              |                종료                ";
        Scanner sc = new Scanner(System.in);


        while (true) {
            System.out.println(message);
            System.out.println(line);
            System.out.printf("%-3s %-15s | W %-4s | %-40s%n", "No", "메뉴", "가격", "설명");
            System.out.println(line);
            int input = 0;
            for (int i = 0; i < menuItems.size(); i++) {
                System.out.printf("%-3d %-15s  | W %-4.1f | %-40s%n",
                        (i + 1),
                        menuItems.get(i).getName(),
                        menuItems.get(i).getPrice(),
                        menuItems.get(i).getDescription());

            }
            System.out.println(messagePrint);

            input = sc.nextInt();
            if (input == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            if (input > 0 && input <= menuItems.size()) {
                MenuItem selectedMenu = menuItems.get(input - 1);
                System.out.printf(" 이름 : %s \n 가격 : %.1f 달러 \n 설명 : %s\n", selectedMenu.getName(), selectedMenu.getPrice(), selectedMenu.getDescription());
            } else {
                System.out.println("다시 입력해주세요");
            }


        }
    }
}
