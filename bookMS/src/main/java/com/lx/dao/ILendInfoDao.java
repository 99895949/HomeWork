package com.lx.dao;

import com.lx.domain.Admin;
import com.lx.domain.LendInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILendInfoDao {

    @Insert("insert into lend (bookID,readerID,beginTime,endTime) values (#{bookID},#{readerID},#{beginTime},#{endTime})")
    void add(LendInfo info);

    @Delete("delete from lend where id = #{id}")
    void remove(Integer id);

    @Update("update lend set bookID = #{bookID},readerID = #{readerID},beginTime = #{beginTime},endTime = #{endTime} where id = #{id}")
    void update(LendInfo info);

    @Select("select * from lend")
    List<LendInfo> getAll();

    @Select("select * from lend where readerID = #{readerID}")
    List<LendInfo> getByReaderName(Integer readerID);

    @Select("select * from lend where bookID = #{bookID}")
    List<LendInfo> getByBookName(Integer bookID);






}
