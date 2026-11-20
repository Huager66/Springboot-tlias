package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.*;
import org.example.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/students")


public class StuController {
    @Autowired
    private StuService stuService;
    @GetMapping
    public Result page(StuQueryParam stuQueryParam) {
        log.info("分页查询: {}", stuQueryParam);
        PageResult<Student> pageResult = stuService.page(stuQueryParam);
        return Result.success(pageResult);
    }
    @PostMapping
    public Result save(@RequestBody Student student) {
        log.info("新增学生: {}", student);
        student.setUpdateTime(LocalDateTime.now());
        stuService.save(student);
        return Result.success();
    }
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids) {
        log.info("删除学生: {}", ids);
        stuService.removeBatchByIds(ids);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id) {
        log.info("根据ID查询学生信息: {}", id);
        Student student = stuService.getById(id);
        return Result.success(student);
    }
    @PutMapping
    public Result update(@RequestBody Student student) {
        log.info("修改学生: {}", student);
        stuService.update(student);
        return Result.success();
    }
    @PutMapping("/violation/{id}/{score}")
    public Result update1(@PathVariable Integer id, @PathVariable Integer score) {
        log.info("修改学生: {}", id, score);
        stuService.update1(id, score);
        return Result.success();
    }

}
