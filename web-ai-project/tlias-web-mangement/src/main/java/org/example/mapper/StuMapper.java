package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.example.StuQueryParam;
import org.example.Student;

import java.util.List;
import java.util.Map;

@Mapper
public interface StuMapper extends BaseMapper<Student> {
    List<Student> list(StuQueryParam stuQueryParam);

    @Update("UPDATE student SET violation_score = #{score} WHERE id = #{id}")
    void update1(Integer id, Integer score);

    List<Map<String, Object>> countStudentDegreeData();

    List<Map<String, Object>> countStudentCountData();
}
