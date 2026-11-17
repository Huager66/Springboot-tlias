package org.example.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.Clazz;
import org.example.ClazzQueryParam;

import java.util.List;

@Mapper
public interface ClazzMapper {


    List<Clazz> list(ClazzQueryParam clazzQueryParam);


    @Delete("delete from clazz where id = #{id}")
    void delete(Integer id);


    void insert(Clazz clazz);

    @Select("select * from clazz where id = #{id}")
    Clazz getById(Integer id);

    void update(Clazz clazz);


    @Select("select * from clazz")
    List<Clazz> list1();
}
