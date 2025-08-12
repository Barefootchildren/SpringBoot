package com.homework.entity;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class ChengXinBuy implements Buy {

    @Override
    public String howToShop() {
        return "使用橙心优选购买";
    }
}
