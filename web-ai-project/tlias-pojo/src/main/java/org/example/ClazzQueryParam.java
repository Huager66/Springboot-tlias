package org.example;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class ClazzQueryParam {
    private Integer page = 1; //页码
    private Integer pageSize = 10; //
    private String name;
    private String room;
    private String status;
    private String masterId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate beginDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end;


}
