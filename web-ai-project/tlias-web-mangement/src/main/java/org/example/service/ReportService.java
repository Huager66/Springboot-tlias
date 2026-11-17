package org.example.service;

import org.example.ClazzCountOption;
import org.example.JobOption;
import org.example.OperateLog;
import org.example.PageResult;

import java.util.List;
import java.util.Map;

public interface ReportService {
    JobOption getEmpJobData();

    List<Map<String, Object>> getEmpGenderData();

    List<Map<String, Object>> getStudentDegreeData();

    ClazzCountOption getStudentCountData();

    PageResult<OperateLog> page(OperateLog operateLog);
}
