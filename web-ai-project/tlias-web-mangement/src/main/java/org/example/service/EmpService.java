package org.example.service;

import org.example.Emp;
import org.example.EmpQueryParam;
import org.example.LoginInfo;
import org.example.PageResult;

import java.util.List;

public interface EmpService {
    PageResult<Emp> page(EmpQueryParam empQueryParam);

    void save(Emp emp);

    void delete(List<Integer> ids);

    Emp getInfo(Integer id);

    void update(Emp emp);

    LoginInfo login(Emp emp);


    List<Emp> getAll();
}
