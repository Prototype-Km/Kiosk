****# Kiosk

## 프로젝트 소개
 - 본 프로젝트는 패스트푸드점 키오스크 시스템을 Java로 구현한 것입니다. 사용자는 햄버거, 음료, 디저트 메뉴를 선택하여 장바구니에 추가하고, 할인 혜택을 적용하여 주문을 완료할 수 있습니다.
 - 클래스의 개념을 이해하고, 객체 지향 설계를 활용해 키오스크를 구현합니다.<br>
  이번 과제의 핵심 목표는 다시 한 번, **자바 문법의 실습과 객체 지향 개념의 적용 입니다.
## 프로젝트 요구사항 정의 및 설계 
 
1. 요구사항 정의
   - 메뉴 선택: 사용자는 햄버거, 음료, 디저트 카테고리에서 원하는 메뉴를 선택할 수 있어야 합니다.
   - 장바구니 기능: 메뉴를 장바구니에 추가 및 삭제할 수 있어야 합니다.
   - 할인 적용: 국가유공자, 군인, 학생에게 각기 다른 할인율을 적용할 수 있어야 합니다.
   - 주문 기능: 장바구니에 담긴 상품을 주문할 수 있어야 합니다.
   - 주문 취소: 주문을 취소하면 장바구니가 초기화되어야 합니다.
   - 입력 예외 처리: 잘못된 입력에 대한 예외 처리가 되어야 합니다.
   
2. 설계
    - 클래스 다이어그램 : Kiosk ,Menu , MenuItem, Cart, Discount
        
    - 기능 분해 :
       - 메뉴 선턱 : 사용자가 메뉴를 보고 장바구니에 추가할 수 있음
       - 장바구니 관리 : 추가된 메뉴를 삭제하거나 전체 삭제할 수 있음
       - 주문 기능 : 장바구니에 담긴 메뉴를 주문 
       - 할인 기능 : 할인 조건에 따라 총 주문 금액에서 할인 적용
       - 에외 처리 : 잘못된 입력에 대한 예외 처리를 수행 
        

    - 데이터 흐름 설계 :
       1. 사용자가 Kiosk를 실행하면 메인 메뉴가 출력됩니다.
       2. 사용자가 메뉴를 선택하면 Menu 클래스에서 해당 카테고리의 MenuItem을 가져옵니다.
       3. 선택된 메뉴는 Cart에 추가됩니다.
       4. 사용자는 장바구니를 확인하고 Order를 진행할 수 있습니다.
       5. 주문 시 할인 정책이 적용됩니다.
       6. 주문 완료 후 Cart가 초기화됩니다
    <br>
   <hr/>

# Stack
<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=OpenJDK&logoColor=white">


# 주요 기능 설명

1. Kiosk (메인 시스템)
 - start() 메서드를 통해 키오스크 기능을 실행합니다.
 - printMainMenu()를 통해 메인 메뉴를 출력합니다.
 - categoryPrint()를 이용해 카테고리별 메뉴를 출력합니다.
 - orderPrint()를 통해 주문 기능을 수행합니다.

2. Cart (장바구니 기능)
 - addItem()을 통해 메뉴 추가
 - getTotalPrice()를 통해 총 가격 계산
 - clear()를 통해 전체 장바구니 비우기
 - removeName()을 통해 특정 메뉴 제거


3. Menu & MenuItem (메뉴 관리)
 - Menu는 Category를 기반으로 MenuItem을 관리합니다.
 - MenuItem은 개별 음식 아이템으로 이름, 가격, 설명, 카테고리를 포함합니다.

4. Discount (할인 적용)
 - DisCount Enum을 활용해 할인 정책을 적용합니다.
 - 국가유공자(10%), 군인(5%), 학생(3%) 할인율을 제공합니다.
<hr/>


# 디렉토리 구조
```
/src
└── /main
    └── /java
        └── /com
            └── /app
                └── Cart.java            // 장바구니 기능
                ├── Category.java        // 카테고리 Enum
                ├── DisCount.java        // 할인 Enum
                ├── Kiosk.java           // 키오스크 메인 시스템
                ├── Main.java            // 실행 파일
                ├── Menu.java            // 메뉴 관리 클래스
                ├── MenuItem.java        // 개별 메뉴 아이템 클래스
```
