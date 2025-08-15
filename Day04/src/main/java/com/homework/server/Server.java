package com.homework.server;

import com.homework.entity.Emp;

import java.util.List;

public interface Server {
    void insert(Emp emp);
    void deleteByID(int id);
    void deleteByCond(Emp emp);
    void updateByID(Emp emp);
    List<Emp> selectAll();
    Emp selectByID(int id);
    List<Emp> selectByCond(Emp emp);
}
