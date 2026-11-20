package org.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.PageResult;
import org.example.StuQueryParam;
import org.example.Student;

import java.util.List;

public interface StuService   extends IService<Student> {
    PageResult<Student> page(StuQueryParam stuQueryParam);

    void update(Student student);

    void update1(Integer id, Integer score);
}
