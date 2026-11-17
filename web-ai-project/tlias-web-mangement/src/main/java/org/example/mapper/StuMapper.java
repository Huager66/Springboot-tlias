package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.StuQueryParam;
import org.example.Student;

import java.util.List;
import java.util.Map;

@Mapper
public interface StuMapper {
    List<Student> list(StuQueryParam stuQueryParam);


    void save(Student student);



    void deleteByids(List<Integer> ids);

    @Select("SELECT * FROM student WHERE id = #{id}")
    Student getById(Integer id);


    void update(Student student);

    @Update("UPDATE student SET violation_score = #{score} WHERE id = #{id}")
    void update1(Integer id, Integer score);

    List<Map<String, Object>> countStudentDegreeData();

    List<Map<String, Object>> countStudentCountData();
}
