package com.app.kiosk;

import java.util.Scanner;

public class Main {
    //실행 시 햄버거 메뉴 표시, 이후 Scanner 숫자 입력받고 메뉴 선택
    // 제시된 메뉴중 입력받은 숫자에 따른 로직 실행 코드 작성
    // 반복문 이용 -> 특정번호 입력되면 프로그램 종료

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String message = "[ K RESTAURANT MENU ] ";
        String[] burgersMenu = {
                           "1. CheeseBurger  | $7.6| 햄버거 먹고싶다. 치즈버거 먹으러가자",
                           "2. HamBugee      | $5.0| 그 유명한 햄부기",
                           "3. ChickenBurger | $8.4| 치킨 goat부기",
                           "4. ShackBurger   | $6.9| 토마토,양상추, 쉑소스가 토핑된 쉑 버거",
                           "0. 종료           |      종료                           "
            };
        while(true){
        System.out.println(message);
        int input = 0;
        for(String menu : burgersMenu){
            System.out.println(menu);
        }
        input = sc.nextInt();

            switch(input){
                case 1:
                    System.out.println("치즈버거 맛있다.");
                    break;
                case 2:
                    System.out.println("햄부기..");
                    break;
                case 3:
                    System.out.println("치킨버거");
                    break;
                case 4:
                    System.out.println("shackBurger");
                    break;
                case 0:
                    System.out.println("종료");
                    return;
            }


        }
    }
}
