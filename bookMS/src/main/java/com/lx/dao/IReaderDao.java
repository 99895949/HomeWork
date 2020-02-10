package com.lx.dao;

import com.lx.domain.Admin;
import com.lx.domain.Reader;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReaderDao {

    @Insert("insert into reader (nickname,realname,password,IDCard,gender,address,email,telephone,type) values (#{nickname},#{realname},#{password},#{idCard},#{gender},#{address},#{email},#{telephone},#{type})")
    void add(Reader reader);

    @Delete("delete from reader where id = #{id}")
    void remove(Integer id);

    @Update("update reader set nickname = #{nickname},realname = #{realname},IDCard = #{idCard},gender = #{gender},address = #{address},password = #{password},email = #{email},telephone = #{telephone},type = #{type} where id = #{id}")
    void update(Reader reader);



    @Select("select *,rt.name from reader r,reader_type rt where rt.id = r.type")
    @Results(id = "readerMap",value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "nickname",column = "nickname"),
            @Result(property = "realname",column = "realname"),
            @Result(property = "password",column = "password"),
            @Result(property = "idCard",column = "IDCard"),
            @Result(property = "gender",column = "gender"),
            @Result(property = "address",column = "address"),
            @Result(property = "email",column = "email"),
            @Result(property = "telephone",column = "telephone"),
            @Result(property = "type",column = "type"),
            @Result(property = "readerTypeStr",column = "name"),
            @Result(property = "readerType",column = "type",one = @One(select = "com.lx.dao.IReaderTypeDao.getReaderTypeByID",fetchType = FetchType.EAGER))
    })
    List<Reader> getAll();

    @Select("select * from reader where type = #{typeID}")
    List<Reader> getReadersByType(Integer typeID);

    @Select("select r.*,rt.name from reader r,reader_type rt where r.type = rt.id and nickname = #{nickname}")
    @ResultMap("readerMap")
    Reader getReader(String nickname);






}
