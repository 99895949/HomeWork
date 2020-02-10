package com.lx.dao;

import com.lx.domain.Book;
import com.lx.domain.Category;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookDao {

    @Insert("insert into book (name,author,publisher,imagePath,isbn,price,description,buyTime,categoryID,status) values (#{name},#{author},#{publisher},#{imagePath},#{isbn},#{price},#{description},#{buyTime},#{categoryID},#{status})")
    void add(Book book);

    @Delete("delete from book where id = #{id}")
    void remove(Integer id);

    @Update("update book set name = #{name},author=#{author},imagePath=#{imagePath},description=#{description},categoryID=#{categoryID},publisher=#{publisher},price=#{price},isbn=#{isbn},status=#{status},buyTime=#{buyTime} where id = #{id} ")
    void update(Book book);



    @Select("select * from book")
    @Results(id = "bookMap",value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "author",column = "author"),
            @Result(property = "publisher",column = "publisher"),
            @Result(property = "imagePath",column = "imagePath"),
            @Result(property = "isbn",column = "isbn"),
            @Result(property = "price",column = "price"),
            @Result(property = "description",column = "description"),
            @Result(property = "buyTime",column = "buyTime"),
            @Result(property = "status",column = "status"),
            @Result(property = "categoryID",column = "categoryID"),
            @Result(property = "category",column = "categoryID",one = @One(select = "com.lx.dao.ICategoryDao.getByID",fetchType= FetchType.EAGER))
    })
    List<Book> getAll();

    @Select("select * from book where isbn = #{isbn}")
    @ResultMap("bookMap")
    Book getBookByIsbn(String isbn);

    @Select("select * from book where author = #{author}")
    @ResultMap("bookMap")
    List<Book> getBookByAuthor(String author);

    @Select("select * from book where name like CONCAT('%',#{name},'%')")
    @ResultMap("bookMap")
    List<Book> getBookByName(String name);

    @Select("select * from book where categoryID = #{id}")
    @ResultMap("bookMap")
    List<Book> getBookByCategoryID(Integer id);

    @Select("select * from book where id = #{id}")
    @ResultMap("bookMap")
    Book getBookById(int id);

}
