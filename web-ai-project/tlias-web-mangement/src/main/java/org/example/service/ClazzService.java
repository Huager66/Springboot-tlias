package org.example.service;

import org.example.Clazz;
import org.example.ClazzQueryParam;
import org.example.PageResult;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ClazzService {
    PageResult<Clazz> page(ClazzQueryParam clazzQueryParam);

    void delete(Integer id);

    void save(Clazz clazz);

    Clazz getInfo(Integer id);

    void update(Clazz clazz);


    List<Clazz> list();
}
