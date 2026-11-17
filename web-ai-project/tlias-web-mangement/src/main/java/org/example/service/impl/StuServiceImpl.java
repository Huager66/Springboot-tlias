package org.example.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.Clazz;
import org.example.PageResult;
import org.example.StuQueryParam;
import org.example.Student;
import org.example.mapper.StuMapper;
import org.example.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StuServiceImpl implements StuService {
    @Autowired
    private StuMapper stuMapper;
    @Override
    public PageResult<Student> page(StuQueryParam stuQueryParam) {
        PageHelper.startPage(stuQueryParam.getPage(), stuQueryParam.getPageSize());
        List<Student> studentList = stuMapper.list(stuQueryParam);
        Page<Student> p = (Page<Student>) studentList;
        return new PageResult<Student>(p.getTotal(), p.getResult());
    }

    @Override
    public void save(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        stuMapper.save(student);

    }

    @Override
    public void delete(List<Integer> ids) {

        stuMapper.deleteByids(ids);
    }

    @Override
    public Student getInfo(Integer id) {
        return stuMapper.getById(id);
    }

    @Override
    public void update(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        stuMapper.update(student);

    }

    @Override
    public void update1(Integer id, Integer score) {
        stuMapper.update1(id, score);
    }


}
