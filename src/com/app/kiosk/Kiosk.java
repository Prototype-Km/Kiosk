package com.app.kiosk;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

//메뉴 관리, 사용자 입력 처리
// MenuItem관리하는 리스트가 필드로 존재
//start함수
//List<MenuItem> menuItems 는 Kiosk
public class Kiosk {

    private final List<Menu> menus;
    private final Cart cart;

    public Kiosk(List<Menu> menus) {
        this.menus = menus;
        this.cart = new Cart();
    }

    public List<Menu> getMenus() {
        return menus;
    }



/*========================================================================
*               키오스크 start
* ========================================================================*/
    void start() {
        String message = "[ K RESTAURANT MENU ] ";
        String line = ("-----------------------------------------------------------");
        String messagePrint = "0.  종료              |                종료                ";
        boolean isCart = false;  //장바구니 체크

        //MAIN MENU
        while (true) {
            int input = -1;
            
            Scanner sc = new Scanner(System.in);

            //메인메뉴 출력하기 , 카테고리 출력
            printMainMenu(isCart);

            /*================================================*/
            /*. isCart true가 아닐때 4,5번 누르면 예외처리 해주기.     */
            /*================================================*/
            try {
                input = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("다시 입력해주세요");
                continue;
            }


            //프로그램 종료
            if (input == 0) {
                System.out.println("프로그램 종료. ");
                break;
            }

            // isCart가 false일 때 4, 5번 입력하면 예외 처리
            if ((input == 4 || input == 5) && !isCart) {
                System.out.println("주문을 하고 입력해주세요");
                continue;
            }
            // 유효하지 않은 입력 처리 (isCart가 false이면 1~3, true이면 1~5)
            int validMax = isCart ? 5 : 3;
            if (input < 0 || input > validMax) {
                System.out.println("다시 입력해주세요");
                continue;
            }

            //-> 카테고리 추가할때 번호도 추가되게 ? ex) 메뉴카테고리 추가되면 메뉴판도 추가

            //햄버거           카테고리 for문으로 -> 1번 받으면 Menu get(i) 넣고, size-1
            try {
                // 2번이면 2번  size-1하고 안에 내용돌려서 뽑가
                if (input == 1) {
                    //
                    isCart = categoryPrint(line,messagePrint,sc,isCart,input);
                }
                // 카테고리 2번째
                if (input == 2) {
                    isCart = categoryPrint(line,messagePrint,sc,isCart,input);
                }
                if (input == 3){
                    isCart = categoryPrint(line,messagePrint,sc,isCart,input);
                }
                //주문 메뉴
                if (input == 4) {
                    isCart =orderPrint(sc,isCart);
                }

                //주문 취소
                if (input == 5) {
                    isCart = false;
                    cart.clear(); //장바구니 삭제
    //                continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("다시 입력해주세요.");
                continue;
            }
        }
    }


    /*========================================================================
     *               print Main 메뉴, 카테고리 출력하기
     * ========================================================================*/
    private void printMainMenu(boolean isCart){
        //카테고리 메인메뉴 출력하기.
//        System.out.println("printMainMenu >>>>> isCart >>>> ");
//        System.out.println(isCart); //true뜸
//        System.out.println(" 주문하고나서========================");
        System.out.println("[           MAIN  MENU          ]");
        for (int i = 0; i < menus.size(); i++) {
            System.out.println((i + 1) + ". " + menus.get(i).getCategory());
        }
        // stream -> 앞에 1,2,3 출력이 안됌.
//         menus.stream().forEach(i-> System.out.println(i.getCategory()));

        if (isCart) {
            System.out.println("[ORDER MENU]");
            System.out.println("4. Orders       | 장바구니를 확인 후 주문합니다.");
            System.out.println("5. Cancel       | 진행중인 주문을 취소합니다.");
        }
        System.out.println("0.      종료");
    }
    /*========================================================================
    * ========================================================================*/


    /*========================================================================
     *               할인 정보 출력, 가격 출력, 주문하면 Order출력안나오게
     * ========================================================================*/
    private boolean discountPrint(Scanner sc){
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

        double finalTotal = total - discount;
        System.out.println("주문이 완료되었습니다. 총 금액은 $ " + total + "입니다. ");
        System.out.println("할인 금액 : "+discount);
        System.out.printf("할인된 금액 : %.2f\n\n", finalTotal);
        //초기화
        boolean isCart = false;
        cart.clear();
//        System.out.println("discountPrint>>>====isCart");
//        System.out.println(isCart);  // false 출력
//        System.out.println("discountPrint>>>====isCart");
        return isCart;
    }
    /*========================================================================
     * ========================================================================*/



    /*========================================================================
     *               주문하기 출력 ,
     * ========================================================================*/
    private boolean orderPrint(Scanner sc, boolean isCart){
        while(true) {
            System.out.println("아래와 같이 주문 하시겠습니까?");
            System.out.println("[Orders]");
            System.out.println(cart.getCarts());
            System.out.println("[Total]");
            System.out.println("$ " + cart.getTotalPrice());
            System.out.println("취소하고 싶은 주문이 있으면 1번을 눌러 주세요 (없으면 아무거나 눌러주세요)");
            int input = sc.nextInt();

            if(input == 1){
                Scanner in = new Scanner(System.in);
                System.out.print("삭제할 상품의 이름을 입력해주세요 >>>");
                String inputOrderName = in.nextLine();
                    if(cart.findByName(inputOrderName)) {
                        cart.removeName(inputOrderName);
                        System.out.println("삭제되었습니다. ");
                        System.out.println("==주문 목록==");
                        System.out.println(cart.getCarts());
                        isCart = !cart.getCarts().isEmpty();
                    }else{
                    System.out.println("삭제할 상품이 존재하지 않습니다.");
                    }
            }
            System.out.println("1. 주문 \t2. 메뉴판");
            input = sc.nextInt();
            if (input == 1) {
                //할인
                isCart = discountPrint(sc);
//                System.out.println("orderPrint >>>");
//                System.out.println(isCart);
                return isCart;

            } else if (input == 2) {
                //메뉴판
                break;
            } else {
                System.out.println("잘못 입력하셨습니다. 1,2만 입력해주세요.");
            }
        }
//        System.out.println("그냥 >>>");
//        System.out.println(isCart);
        return isCart;
    }
    /*========================================================================
     * ========================================================================*/



    /*========================================================================
     *                  카테고리별 메뉴 출력하기
     * ========================================================================*/
    private boolean categoryPrint(String line,String messagePrint, Scanner sc,boolean isCart,int input) {
        while (true) {
            System.out.println(line);
            //< 줄이 안맞아서 ,서식 형식은 gpt 사용했음>
            System.out.printf("%-3s %-15s | W %-4s | %-40s%n", "No", "메뉴", "가격", "설명");
            System.out.println(line);

            //카테고리 input값 받아서  (i)대입  , input -1해줘야함 -> HAMBURGERS -> 0 , DRINKS -> 1
//            System.out.println("============");
//            System.out.println(menus.get(input-1).getMenuItems());
//            System.out.println("============");
            // 1-1 => 0 햄버거 카테고리
            Menu menu = menus.get(input-1);
            for(int i=0; i< menu.getMenuItems().size(); i++){
                MenuItem item = menu.getMenuItems().get(i); //각 햄버거
                System.out.printf("%-3d %-15s | %-5.1f$ | %-40s%n",
                        (i + 1),
                        item.getName(),
                        item.getPrice(),
                        item.getDescription());
            }
            System.out.println("5. 이전단계로 돌아가기");
            System.out.println(messagePrint);

            int choice = sc.nextInt();
                if (choice == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                }
                if (choice == 5) {
                    break;
                }

            if (choice > 0 && choice <= menu.getMenuItems().size()) {
                //선택된 카테고리 출력하기
                MenuItem selectedMenu = menu.getMenuItems().get(choice - 1);
                System.out.printf(" 이름 : %s \n 가격 : %.1f 달러 \n 설명 : %s\n", selectedMenu.getName(), selectedMenu.getPrice(), selectedMenu.getDescription());
                System.out.println();
                System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                System.out.println();
                System.out.print("1. 확인 \t2. 취소");
                choice = sc.nextInt();

                if (choice == 1) {
                    cart.addItem(selectedMenu);
                    System.out.println(selectedMenu.getName() + "이(가) 장바구니에 추가되었습니다.");
                    isCart = true;
                    break;
                }

            } else {
                System.out.println("다시 입력해주세요");
                continue;
            }
            return isCart;
        }
        return isCart;
    }
    /*========================================================================
    * ========================================================================*/
}

