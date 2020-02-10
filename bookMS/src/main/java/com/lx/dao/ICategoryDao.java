package com.lx.dao;

import com.lx.domain.Category;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICategoryDao {

    @Insert("insert into category (name) values (#{name})")
    void add(Category category);

    @Delete("delete from category where id = #{id}")
    void remove(Integer id);

    @Update("update category set name = #{name} where id = #{id}")
    void update(Category category);

    @Select("select * from category order by id")
    List<Category> getAll();

    @Select("select * from category where name = #{name}")
    Category getByName(String name);

    @Select("select * from category where id = #{id}")
    Category getByID(Integer id);
}
