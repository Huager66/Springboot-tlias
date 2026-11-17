package org.example.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.*;
import org.example.mapper.EmpMapper;
import org.example.mapper.OperateLogMapper;
import org.example.mapper.StuMapper;
import org.example.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private StuMapper stuMapper;
    @Autowired
    private OperateLogMapper operateLogMapper;

    @Override
    public JobOption getEmpJobData() {
        //1. 查询数据库：[{job=1, total=3}, {job=2, total=5}...]
        List<Map<String, Object>> list = empMapper.countEmpJobData();

        //2. 封装成 ECharts 需要的 option 结构
        List<Object> jobList = list.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("num")).toList();

        return new JobOption(jobList, dataList);
    }

    @Override
    public List<Map<String, Object>> getEmpGenderData() {
        return empMapper.countEmpGenderData();
    }

    @Override
    public List<Map<String, Object>> getStudentDegreeData() {
        return stuMapper.countStudentDegreeData();
    }

    @Override
    public ClazzCountOption getStudentCountData() {
        List<Map<String, Object>> list = stuMapper.countStudentCountData();
        List<Object> clazzList = list.stream().map(dataMap -> dataMap.get("name")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("value")).toList();
        return new ClazzCountOption(clazzList, dataList);

    }

    @Override
    public PageResult<OperateLog> page(OperateLog operateLog) {
        PageHelper.startPage(operateLog.getPage(), operateLog.getPageSize());
        List<OperateLog> logList = operateLogMapper.page(operateLog);
        Page<OperateLog> p = (Page<OperateLog>) logList;
        return new PageResult<OperateLog>(p.getTotal(), p.getResult());
    }
}
