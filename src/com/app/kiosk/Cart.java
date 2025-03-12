package com.app.kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//장바구니에 -> 음식 담아야함
public class Cart {
    private final List<MenuItem> carts;


    public Cart(){
        this.carts = new ArrayList<>();
    }

    public void addItem(MenuItem item){
        carts.add(item);

    }
    public List<MenuItem> getCarts(){
        return carts;
    }
    //토탈값
    public double getTotalPrice(){
        double result =0.0;
        for(MenuItem cart: carts){
            result +=cart.getPrice();
        }
        return result;
    }
    //전체삭제
    public void clear(){
        carts.clear();;
    }
//    이름찾기
    public boolean findByName(String name) {
        return carts.stream().anyMatch(i -> i.getName().equals(name));
    }
//   값 삭제
    public void removeName(String name){
        carts.removeIf(i -> i.getName().equals(name));
    }

}
