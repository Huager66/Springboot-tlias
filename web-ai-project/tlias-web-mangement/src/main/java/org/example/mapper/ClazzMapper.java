package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.Clazz;
import org.example.ClazzQueryParam;

import java.util.List;

@Mapper
public interface ClazzMapper extends BaseMapper<Clazz> {


    List<Clazz> list(ClazzQueryParam clazzQueryParam);

}
