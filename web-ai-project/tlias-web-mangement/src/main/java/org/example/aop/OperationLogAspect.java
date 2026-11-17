package org.example.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.example.OperateLog;
import org.example.mapper.OperateLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@Aspect
@Component

public class OperationLogAspect {
    @Autowired
    private OperateLogMapper operateLogMapper;
    @Around("execution(* org.example.controller..*.*(..))")
    public Object logOperation(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        // 执行目标方法
        Object result = joinPoint.proceed();

        // 计算耗时
        long endTime = System.currentTimeMillis();
        long costTime = endTime - startTime;


        // 构建日志实体
        OperateLog olog = new OperateLog();
        olog.setOperateEmpId(getCurrentUserId()); // 从请求头 token 中解析当前登录人 ID
        olog.setOperateTime(LocalDateTime.now());
        olog.setClassName(joinPoint.getTarget().getClass().getName());
        olog.setMethodName(joinPoint.getSignature().getName());
        olog.setMethodParams(Arrays.toString(joinPoint.getArgs()));
        olog.setReturnValue(result != null ? result.toString() : "void");
        olog.setCostTime(costTime);

        log.info("操作日志：{}", olog);
        if (result != null) {
            // 把返回结果转成字符串
            String returnValueStr = result.toString();

            // 判断长度，超过 2000 字符就截断
            if (returnValueStr.length() > 1000) {
                returnValueStr = returnValueStr.substring(0, 1000) + "...[数据过长已截断]";
            }

            // 把截断后的字符串设置进日志对象
            olog.setReturnValue(returnValueStr);
        }

        // 保存日志
        operateLogMapper.insert(olog);

        return result;

    }
    private Integer getCurrentUserId() {
        // 从请求头 token 中解析当前登录人 ID
        return 1; // 示例中直接返回 "1"
    }
}
