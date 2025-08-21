package com.homework.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

import javax.swing.*;

public enum UserStatus {
    ACTIVE(0,"激活"),
    INACTIVE(1,"未激活");

    @EnumValue
    private final Integer statusValue;
    private final String statusDesc;

    UserStatus(Integer statusValue,String statusDesc){
        this.statusValue=statusValue;
        this.statusDesc=statusDesc;
    }

    public String toString(){
        return this.statusDesc;
    }
}
