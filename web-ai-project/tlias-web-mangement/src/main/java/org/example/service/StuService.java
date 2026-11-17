package org.example.service;

import org.example.PageResult;
import org.example.StuQueryParam;
import org.example.Student;

import java.util.List;

public interface StuService {
    PageResult<Student> page(StuQueryParam stuQueryParam);

    void save(Student student);


    void delete(List<Integer> ids);

    Student getInfo(Integer id);

    void update(Student student);

    void update1(Integer id, Integer score);
}
