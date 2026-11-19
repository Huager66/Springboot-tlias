package org.example.exception;

import lombok.extern.slf4j.Slf4j;
import org.example.Result;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public Result handleException(Exception e) {
        log.error("程序出错啦~", e);
        return Result.error("出错啦，请联系管理员~");
    }
    @ExceptionHandler
    public Result handleDuplicateKeyException(DuplicateKeyException e) {
        log.error("数据库中已存在当前记录", e);
        String message = e.getMessage();
        int i = message == null ? -1 : message.indexOf("Duplicate entry");
        if (i < 0) {
            return Result.error("数据重复，请检查后重新提交");
        }
        String[] arr = message.substring(i).split(" ");
        if (arr.length < 3) {
            return Result.error("数据重复，请检查后重新提交");
        }
        //去掉两端单引号，提示更干净：销售部 已存在
        String value = arr[2].replaceAll("^'|'$", "");
        return Result.error(value + " 已存在");
    }
}