package com.app.kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//메뉴 관리, 사용자 입력 처리
// MenuItem관리하는 리스트가 필드로 존재
//start함수
//List<MenuItem> menuItems 는 Kiosk
public class Kiosk {

    private final List<Menu> menus;
    private Cart cart;

    public Kiosk(List<Menu> menus) {
        this.menus = menus;
        this.cart = new Cart();
    }

    public List<Menu> getMenus() {
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
        boolean isFlag = false;
        //MAIN MENU
        while (true) {
            int input = -1;

            Scanner sc = new Scanner(System.in);
            //카테고리 메인메뉴 출력하기.
            System.out.println("[  MAIN  MENU  ] ");
            for (int i = 0; i < menus.size(); i++) {
                System.out.println((i + 1) + ". " + menus.get(i).getCategory());
            }

            if (isFlag) {
                System.out.println("[ORDER MENU]");
                System.out.println("4. Orders       | 장바구니를 확인 후 주문합니다.");
                System.out.println("5. Cancel       | 진행중인 주문을 취소합니다.");
            }
            System.out.println("0 . 종료 ");
            /*================================================*/
            /*. isFlag true가 아닐때 4,5번 누르면 예외처리 해주기.     */
            /*================================================*/
            input = sc.nextInt();

            if (input == 5) {
                isFlag = false;
                cart.clear(); //주문 취소
                continue;
            }
            if (input == 4) {
                System.out.println("아래와 같이 주문 하시겠습니까?");
                System.out.println("[Orders]");
                System.out.println(cart.getCarts());
                System.out.println("[Total]");
                System.out.println("$ " + cart.getTotalPrice());
                System.out.println("1. 주문 \t2. 메뉴판");
                input = sc.nextInt();

                if (input == 1) {

                    System.out.println("할인 정보를 입력해주세요.");
                    System.out.println("1. 국가유공자 : 10%\n2. 군인 : 5%\n3. 학생 : 3%\n5. 일반 : 0%");
                    //할인정보
                    int discountChoice = sc.nextInt();
                    double discount = 0.0;
                    double total = cart.getTotalPrice();
                    if(discountChoice == 1){
                         discount = DisCount.NATIONAL_VIP.getDisCountPercent(cart.getTotalPrice());
                    }else if(discountChoice ==2){
                         discount = DisCount.SOLDIER.getDisCountPercent(cart.getTotalPrice());
                    }else if(discountChoice == 3){
                         discount = DisCount.STUDENT.getDisCountPercent(cart.getTotalPrice());
                    }
                    double finalTotal = total -discount;
                    System.out.println("주문이 완료되었습니다. 총 금액은 $ " + total + "입니다. ");
                    System.out.println("할인 금액 : "+discount);
                    System.out.println("할인된 금액 : "+finalTotal);
                    //초기화
                    cart.clear();
                    isFlag = false;
                }
                //주문 아니면 다시
                continue;

            }
            if (input == 0) {
                break;
            }
            //햄버거
            if (input == 1) {
                while (true) {
                    System.out.println(line);
                    System.out.printf("%-3s %-15s | W %-4s | %-40s%n", "No", "메뉴", "가격", "설명");
                    System.out.println(line);
                    Menu menu = menus.get(Category.HAMBURGERS.ordinal());
                    for (int i = 0; i < menu.getMenuItems().size(); i++) {
                        System.out.printf((i + 1) + ". %s\t", menu.getMenuItems().get(i).getName());
                        System.out.printf("    %.1f$  \t", menu.getMenuItems().get(i).getPrice());
                        System.out.printf(" %s\n", menu.getMenuItems().get(i).getDescription());
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

                    if (input > 0 && input <= menu.getMenuItems().size()) {
                        //선택된 버거
                        MenuItem selectedMenu = menu.getMenuItems().get(input - 1);
                        System.out.printf(" 이름 : %s \n 가격 : %.1f 달러 \n 설명 : %s\n", selectedMenu.getName(), selectedMenu.getPrice(), selectedMenu.getDescription());

                        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                        System.out.print("1. 확인 \t2. 취소");
                        input = sc.nextInt();
                        if (input == 1) {
                            cart.addItem(selectedMenu);
                            System.out.println(selectedMenu.getName() + "이(가) 장바구니에 추가되었습니다.");
                            isFlag = true;
                            break;
                        }

                    } else {
                        System.out.println("다시 입력해주세요");
                        continue;
                    }
                }
            }
            //drink /*메소드로*/
            if (input == 2) {
                while (true) {
//                        System.out.println(message);
                    System.out.println(line);
                    System.out.printf("%-3s %-15s | W %-4s | %-40s%n", "No", "메뉴", "가격", "설명");
                    System.out.println(line);
                    Menu drinkMenu = menus.get(Category.DRINKS.ordinal());
                    for (int i = 0; i < drinkMenu.getMenuItems().size(); i++) {
                        System.out.printf((i + 1) + ". %s\t", drinkMenu.getMenuItems().get(i).getName());
                        System.out.printf("    %.1f$  \t", drinkMenu.getMenuItems().get(i).getPrice());
                        System.out.printf(" %s\n", drinkMenu.getMenuItems().get(i).getDescription());
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

                    if (input > 0 && input <= drinkMenu.getMenuItems().size()) {
                        //음료수
                        MenuItem selectedMenu = drinkMenu.getMenuItems().get(input - 1);
                        System.out.printf(" 이름 : %s \n 가격 : %.1f 달러 \n 설명 : %s\n", selectedMenu.getName(), selectedMenu.getPrice(), selectedMenu.getDescription());

                        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                        System.out.print("1. 확인 \t2. 취소");
                        input = sc.nextInt();
                        if (input == 1) {
                            cart.addItem(selectedMenu);
                            System.out.println(selectedMenu.getName() + "이(가) 장바구니에 추가되었습니다.");
                            isFlag = true;
                            break;
                        }

                    } else {
                        System.out.println("다시 입력해주세요");
                        continue;
                    }
                }
            }
        }
    }
}

