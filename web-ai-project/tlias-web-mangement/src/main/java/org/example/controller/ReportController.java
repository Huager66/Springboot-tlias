package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.*;
import org.example.anno.Log;
import org.example.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/report")

public class ReportController {
    @Autowired
    private ReportService reportService;

    @GetMapping("/empJobData")
    public Result getEmpJobData() {
        log.info("统计员工职位人数");
        JobOption jobOption = reportService.getEmpJobData();
        return Result.success(jobOption);
    }

    @GetMapping("/empGenderData")
    public Result getEmpGenderData() {
        log.info("统计员工性别人数");
        List<Map<String, Object>> genderList = reportService.getEmpGenderData();
        return Result.success(genderList);
    }
    @GetMapping("/studentDegreeData")
    public Result studentDegreeData() {
        log.info("统计学生学历人数");
        List<Map<String, Object>> degreeList = reportService.getStudentDegreeData();
        return Result.success(degreeList);
    }
    @GetMapping("/studentCountData")
    public Result studentCountData() {
        log.info("统计学生人数");
        ClazzCountOption clazzCountOption = reportService.getStudentCountData();
        return Result.success(clazzCountOption);
    }
    @GetMapping("/log/page")
    public Result page(OperateLog operateLog) {
        log.info("分页查询: {}", operateLog);
        PageResult<OperateLog> pageResult = reportService.page(operateLog);
        return Result.success(pageResult);
    }
}
