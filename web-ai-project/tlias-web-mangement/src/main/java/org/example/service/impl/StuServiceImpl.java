package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class StuServiceImpl extends ServiceImpl<StuMapper, Student> implements StuService {
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
    public void update(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        lambdaUpdate()
                .set(student.getName() != null && !student.getName().isEmpty(), Student::getName, student.getName())
                .set(student.getNo() != null && !student.getNo().isEmpty(), Student::getNo, student.getNo())
                .set(student.getGender() != null, Student::getGender, student.getGender())
                .set(student.getPhone() != null && !student.getPhone().isEmpty(), Student::getPhone, student.getPhone())
                .set(student.getIdCard() != null && !student.getIdCard().isEmpty(), Student::getIdCard, student.getIdCard())
                .set(student.getIsCollege() != null, Student::getIsCollege, student.getIsCollege())
                .set(student.getAddress() != null && !student.getAddress().isEmpty(), Student::getAddress, student.getAddress())
                .set(student.getDegree() != null, Student::getDegree, student.getDegree())
                .set(student.getGraduationDate() != null, Student::getGraduationDate, student.getGraduationDate())
                .set(student.getClazzId() != null, Student::getClazzId, student.getClazzId())
                .set(student.getViolationCount() != null, Student::getViolationCount, student.getViolationCount())
                .set(student.getViolationScore() != null, Student::getViolationScore, student.getViolationScore())
                .set(student.getUpdateTime() != null, Student::getUpdateTime, student.getUpdateTime())
                .update(student);

    }

    @Override
    public void update1(Integer id, Integer score) {
        stuMapper.update1(id, score);
    }
}
