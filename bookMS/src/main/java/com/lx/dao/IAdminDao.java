package com.lx.dao;

import com.lx.domain.Admin;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAdminDao {

    @Insert("insert into admin (nickname,password,telephone) values (#{nickname},#{password},#{telephone})")
    void add(Admin admin);

    @Delete("delete from admin where id = #{id}")
    void remove(Integer id);

    @Update("update admin set nickname = #{nickname},password = #{password},telephone = #{telephone} where id = #{id}")
    void update(Admin admin);

    @Select("select * from admin where nickname = #{nickname} and password = #{password}")
    Admin getAdmin(@Param("nickname") String nickname, @Param("password") String password);

    @Select("select * from admin")
    List<Admin> getAll();






}
