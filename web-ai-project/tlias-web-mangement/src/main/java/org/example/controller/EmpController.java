package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.Emp;
import org.example.EmpQueryParam;
import org.example.PageResult;
import org.example.Result;
import org.example.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {
    @Autowired
    private EmpService empService;
    @GetMapping
    public Result page(EmpQueryParam empQueryParam) {
        log.info("分页查询: {}", empQueryParam);
        PageResult<Emp> pageResult = empService.page(empQueryParam);
        return Result.success(pageResult);
    }
    @PostMapping
    public Result save(@RequestBody Emp emp) {
        log.info("新增员工: {}", emp);
        empService.save(emp);
        return Result.success();
    }
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids) {
        log.info("删除员工: {}", ids);
        empService.delete(ids);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id) {
        log.info("根据ID查询员工信息: {}", id);
        Emp emp = empService.getInfo(id);
        return Result.success(emp);
    }
    @PutMapping
    public Result update(@RequestBody Emp emp) {
        log.info("修改员工: {}", emp);
        empService.update(emp);
        return Result.success();
    }

    @GetMapping("/list")
    public Result  getAll() {
        log.info("查询所有员工信息");
        List<Emp> emps = empService.getAll();
        return Result.success(emps);
    }

}
