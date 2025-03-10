package com.app.kiosk;

public enum DisCount {
    NATIONAL_VIP(10),
    SOLDIER(5),
    STUDENT(3),
    GENERAL(0);


    public final double disCountPercent;

    DisCount(double disCountPercent) {
        this.disCountPercent = disCountPercent;
    }

    //할인값
    double getDisCountPercent(double price) {
        return price * disCountPercent / 100;
    }
}
