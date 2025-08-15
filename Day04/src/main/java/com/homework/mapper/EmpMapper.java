package com.homework.mapper;

import com.homework.entity.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface EmpMapper {
    @Insert("insert into day04emp values (default,#{name},#{addr},#{dept},#{age})")
    void insert(Emp emp);
    @Delete("delete from day04emp where id=#{id}")
    void deleteByID(int id);
    void deleteByCond(Emp emp);
    @Update("update day04emp set name=#{name},addr=#{addr},dept=#{dept},age=#{age} where id=#{id}")
    void updateByID(Emp emp);
    @Select("select * from day04emp")
    List<Emp> selectAll();
    @Select("select * from day04emp where id=#{id}")
    Emp selectByID(int id);
    List<Emp> selectByCond(Emp emp);

}
