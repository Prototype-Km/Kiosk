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


        Scanner sc = new Scanner(System.in);

        String message = "[ K RESTAURANT MENU ] ";
        String line = ("-----------------------------------------------------------");

        String messagePrint = "0.  종료              |                종료                ";


        while(true){
        System.out.println(message);
            System.out.println(line);
            System.out.printf("%-3s %-15s | W %-4s | %-40s%n", "No", "메뉴", "가격", "설명");
            System.out.println(line);
        int input = 0;
            for(int i=0; i<menuItems.size(); i++){
                System.out.printf("%-3d %-15s  | W %-4.1f | %-40s%n",
                        (i + 1),
                        menuItems.get(i).getName(),
                        menuItems.get(i).getPrice(),
                        menuItems.get(i).getDescription());

            }
        System.out.println(messagePrint);

        input = sc.nextInt();
            if(input == 0){
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            if(input > 0 && input <= menuItems.size()){
                MenuItem selectedMenu = menuItems.get(input-1);
                System.out.printf(" 이름 : %s \n 가격 : %.1f 달러 \n 설명 : %s\n",selectedMenu.getName(),selectedMenu.getPrice(),selectedMenu.getDescription());
            }else{
                System.out.println("다시 입력해주세요");
            }


        }
    }
}
