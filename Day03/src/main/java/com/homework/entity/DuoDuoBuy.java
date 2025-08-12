package com.homework.entity;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("test")
public class DuoDuoBuy implements Buy{
    @Override
        public String howToShop() {
        return "使用多多买菜购买";
    }
}
