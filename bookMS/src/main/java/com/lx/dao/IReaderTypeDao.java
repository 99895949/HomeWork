package com.lx.dao;

import com.lx.domain.Admin;
import com.lx.domain.ReaderType;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReaderTypeDao {

    @Insert("insert into reader_type (name,borrowTime) values (#{name},#{borrowTime})")
    void add(ReaderType readerType);

    @Delete("delete from reader_type where id = #{id}")
    void remove(Integer id);

    @Update("update reader_type set name = #{name},borrowTime = #{borrowTime} where id = #{id}")
    void update(ReaderType readerType);



    @Select("select * from reader_type")
    List<ReaderType> getAll();

    @Select("select * from reader_type where id = #{id}")
    ReaderType getReaderTypeByID(Integer id);








}
