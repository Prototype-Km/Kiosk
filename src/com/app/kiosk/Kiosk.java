package com.app.kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//메뉴 관리, 사용자 입력 처리
// MenuItem관리하는 리스트가 필드로 존재
//start함수
//List<MenuItem> menuItems 는 Kiosk
public class Kiosk {

    private List<Menu> menus;

    public Kiosk(List<Menu> menus) {
        this.menus = menus;
    }
    public List<Menu> getMenus(){
        return menus;
    }

    //  요구사항  키오스크에서 메뉴item관리하는게 아니라 Menu에서 함
//    private List<MenuItem> menuItems = new ArrayList<>();

//    public Kiosk(List<MenuItem> menuItems) {
//        this.menuItems = menuItems;
//    }

    void start() {
        String message = "[ K RESTAURANT MENU ] ";
        String line = ("-----------------------------------------------------------");
        String messagePrint = "0.  종료              |                종료                ";

        //MAIN MENU
        while(true){
            int input = -1;

            Scanner sc = new Scanner(System.in);
            //카테고리 메인메뉴 출력하기.
            System.out.println("[  MAIN  MENU  ] ");
            for(int i=0; i<menus.size(); i++){
                System.out.println((i+1)+". "+menus.get(i).getCategory());
            }
            System.out.println("0 . 종료 ");
            input = sc.nextInt();
            if (input == 0) {
                break;
            }

                //햄버거
                if (input == 1) {
                    while (true) {
                        System.out.println(message);
                        System.out.println(line);
                        System.out.printf("%-3s %-15s | W %-4s | %-40s%n", "No", "메뉴", "가격", "설명");
                        System.out.println(line);
                        for (int i = 0; i < menus.get(0).getMenuItems().size(); i++) {
                            System.out.printf("%-3d %-15s  | W %-4.1f | %-40s%n",
                                    (i + 1),
                                    menus.get(0).getMenuItems().get(i).getName(),
                                    menus.get(0).getMenuItems().get(i).getPrice(),
                                    menus.get(0).getMenuItems().get(i).getDescription());
                        }
                        System.out.println("5. 이전단계로 돌아가기");
                        System.out.println(messagePrint);

                        input = sc.nextInt();
                        if (input == 5) {
                            break;
                        }
                        if (input == 0) {
                            System.out.println("프로그램을 종료합니다.");
                            return;
                        }
                        if (input > 0 && input <= menus.get(0).getMenuItems().size()) {
                            MenuItem selectedMenu = menus.get(0).getMenuItems().get(input - 1);
                            System.out.printf(" 이름 : %s \n 가격 : %.1f 달러 \n 설명 : %s\n", selectedMenu.getName(), selectedMenu.getPrice(), selectedMenu.getDescription());
                        } else {
                            System.out.println("다시 입력해주세요");
                            continue;
                        }
                    }
                }
                //Drinks
                if(input == 2){
                    while(true){
                    System.out.println(message);
                    System.out.println(line);
                    System.out.printf("%-3s %-15s | W %-4s | %-40s%n", "No", "메뉴", "가격", "설명");
                    System.out.println(messagePrint);
                        for(int i=0; i<menus.get(1).getMenuItems().size(); i++){
                            System.out.printf("%-3d %-15s  | W %-4.1f | %-40s%n",
                                    (i + 1),
                                    menus.get(1).getMenuItems().get(i).getName(),
                                    menus.get(1).getMenuItems().get(i).getPrice(),
                                    menus.get(1).getMenuItems().get(i).getDescription());
                        }
                        System.out.println("5. 이전단계로 돌아가기");
                        System.out.println(messagePrint);

                        input = sc.nextInt();
                        if(input == 5){
                            break;
                        }
                        if (input == 0) {
                            System.out.println("프로그램을 종료합니다.");
                            return;
                        }
                        if (input > 0 && input <= menus.get(1).getMenuItems().size()) {
                            MenuItem selectedMenu = menus.get(1).getMenuItems().get(input - 1);
                            System.out.printf(" 이름 : %s \n 가격 : %.1f 달러 \n 설명 : %s\n", selectedMenu.getName(), selectedMenu.getPrice(), selectedMenu.getDescription());
                        } else {
                            System.out.println("다시 입력해주세요");
                            continue;
                        }

                    }
                }
        }
    }
}
