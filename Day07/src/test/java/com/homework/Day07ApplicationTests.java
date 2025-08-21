package com.homework;

import com.homework.entity.Acc;
import com.homework.entity.User;
import com.homework.enums.UserStatus;
import com.homework.service.AccServiceImpl;
import com.homework.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Day07ApplicationTests {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private AccServiceImpl accService;
    @Test
    void insert() {
        User user=new User();
        user.setName("刘二").setPassword("liuer").setStatus(UserStatus.ACTIVE);
        userService.save(user);
    }
    @Test
    void updateByAR(){
        User user = new User();
        user.setId(1958531564249964546L).setName("liuyi1");
        user.updateById();
    }
    @Test
    void accInsert(){
        Acc acc=new Acc();
        acc.setName("刘一").setBalance(1000000);
        accService.save(acc);
    }
    @Test
    void accUpdate(){
        Acc acc = accService.getById(1958668400595300353L);
        acc.setBalance(acc.getBalance()+100000);
        accService.updateById(acc);
    }
}
