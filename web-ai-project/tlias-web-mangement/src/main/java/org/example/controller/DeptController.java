package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.Dept;
import org.example.Result;
import org.example.anno.Log;
import org.example.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {
    @Autowired

    private DeptService deptService;

    @GetMapping
    public Result list() {
        List<Dept> deptList= deptService.findAll();
        log.info("查询全部部门数据");
        return Result.success(deptList);
    }
    @Log
    @DeleteMapping
    public Result delete(Integer id) {
        deptService.deleteById(id);
        log.info("根据ID删除部门: {}", id);
        return Result.success();
    }
    @Log
    @PostMapping
    public Result add(@RequestBody Dept dept) {
        deptService.add(dept);
        log.info("新增部门:{}", dept);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id) {
        Dept dept = deptService.getById(id);
        log.info("根据ID查询部门: {}", id);
        return Result.success(dept);
    }
    @Log
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        deptService.update(dept);
        log.info("修改部门:{}", dept);
        return Result.success();
    }
}
