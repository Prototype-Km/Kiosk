package com.app.kiosk;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    public final List<MenuItem> carts;
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


}
