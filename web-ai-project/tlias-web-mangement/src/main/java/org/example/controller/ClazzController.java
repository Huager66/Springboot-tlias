package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.*;
import org.example.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/clazzs")

public class ClazzController {
    @Autowired
    private ClazzService clazzService;
    @GetMapping
    public Result page(ClazzQueryParam clazzQueryParam) {
        log.info("分页查询: {}", clazzQueryParam);
        PageResult<Clazz> pageResult = clazzService.page(clazzQueryParam);
        return Result.success(pageResult);
    }
    @DeleteMapping ("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("根据ID删除班级信息: {}", id);
        clazzService.removeById(id);
        return Result.success();
    }
    @PostMapping
    public Result save(@RequestBody Clazz clazz) {
        log.info("新增班级: {}", clazz);
        clazz.setUpdateTime(LocalDateTime.now());
        clazzService.save(clazz);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id) {
        log.info("根据ID查询员工信息: {}", id);
        Clazz clazz = clazzService.getById(id);
        return Result.success(clazz);
    }
    @PutMapping
    public Result update(@RequestBody Clazz clazz) {
        log.info("修改班级: {}", clazz);
        clazzService.update(clazz);
        return Result.success();
    }
    @GetMapping("/list")
    public Result getList() {
        log.info("查询所有员工");
        List<Clazz> clazz = clazzService.list();
        return Result.success(clazz);
    }
}
