package com.homework.entity;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class MeiTuanBuy implements Buy{
    @Override
    public String howToShop() {
        return "使用美团优选购买";
    }
}
