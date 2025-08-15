package com.homework.server.impl;

import com.homework.entity.Emp;
import com.homework.mapper.EmpMapper;
import com.homework.server.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServerImpl implements Server {
    @Autowired
    private EmpMapper mapper;
    @Override
    public void insert(Emp emp) {
        mapper.insert(emp);
    }

    @Override
    public void deleteByID(int id) {
        mapper.deleteByID(id);
    }

    @Override
    public void deleteByCond(Emp emp) {
        mapper.deleteByCond(emp);
    }

    @Override
    public void updateByID(Emp emp) {
        mapper.updateByID(emp);
    }


    @Override
    public List<Emp> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public Emp selectByID(int id) {
        return mapper.selectByID(id);
    }

    @Override
    public List<Emp> selectByCond(Emp emp) {
        return mapper.selectByCond(emp);
    }
}
