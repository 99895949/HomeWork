package com.lx.emp.dao;

import com.lx.emp.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AdminMapper {

    @Select("select * from tb_admin where admin_name = #{adminName}")
    Admin getByName(@Param("adminName") String adminName);

    @Update("UPDATE tb_admin set admin_password = #{adminPassword} where admin_name = #{adminName}")
    int changePassword(@Param("adminName") String adminName,@Param("adminPassword") String adminPassword);


}