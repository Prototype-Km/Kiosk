package com.app.kiosk;

import java.util.ArrayList;
import java.util.List;

//MenuItem 클래스를 관리하는 클래스
//예를 들어, 버거 메뉴, 음료 메뉴 등 각 카테고리 내에 여러 MenuItem을 포함합니다.
public class Menu {

      private final Category category;
      private final List<MenuItem> menuItems;


    public Menu(Category category) {
        //카테고리
        this.category = category;
        //카테고리 하나 받고, ex) Drink -> 아메리카노, 주스 등 리스트 받기
        this.menuItems = new ArrayList<>();
    }

    public void addMenuItem(final MenuItem item) {
        if (item.getCategory().equals(this.category)) {
            menuItems.add(item);
        } else {
            throw new IllegalArgumentException("MenuItem의 카테고리가 일치하지 않습니다.");
        }
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public Category getCategory() {
        return category;
    }

}
