package org.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.example.Emp;
import org.example.EmpQueryParam;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmpMapper {

    @Select("select count(*) from emp e left join dept d on e.dept_id = d.id")
    public Long count();


    public List<Emp> list( EmpQueryParam empQueryParam);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp(username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time)" +
            " values (#{username}, #{name}, #{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);

    void deleteByIds(List<Integer> ids);

    Emp getById(Integer id);

    void updateById(Emp emp);

    List<Map<String, Object>> countEmpJobData();

    List<Map<String, Object>> countEmpGenderData();

    @Select("select  id, username,name from emp where username = #{username} and password = #{password}")
    Emp selectByUsernameAndPassword(Emp emp);

    @Select("select * from emp")
    List<Emp> getAll();
}

