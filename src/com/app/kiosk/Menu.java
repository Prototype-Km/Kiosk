package com.app.kiosk;

import java.util.List;

//MenuItem 클래스를 관리하는 클래스
//예를 들어, 버거 메뉴, 음료 메뉴 등 각 카테고리 내에 여러 MenuItem을 포함합니다.
public class Menu {

    //밖에서 안바뀌게 final 로 선언
      private final String category;
      private final List<MenuItem> menuItems;


    public Menu(String category, List<MenuItem> menuItems) {
        this.category = category;
        this.menuItems = menuItems;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public String getCategory() {
        return category;
    }

}
