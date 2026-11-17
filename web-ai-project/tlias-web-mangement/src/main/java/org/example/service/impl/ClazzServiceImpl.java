package org.example.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.*;
import org.example.mapper.ClazzMapper;
import org.example.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    private ClazzMapper clazzMapper;
    @Override
    public PageResult<Clazz> page(ClazzQueryParam clazzQueryParam) {
        PageHelper.startPage(clazzQueryParam.getPage(), clazzQueryParam.getPageSize());
        List<Clazz> clazzList = clazzMapper.list(clazzQueryParam);
        Page<Clazz> p = (Page<Clazz>) clazzList;
        return new PageResult<Clazz>(p.getTotal(), p.getResult());
    }

    @Override
    public void delete(Integer id) {
        clazzMapper.delete(id);
    }

    @Override
    public void save(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.insert(clazz);
    }

    @Override
    public Clazz getInfo(Integer id) {
        return clazzMapper.getById(id);
    }

    @Override
    public void update(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.update(clazz);
    }

    @Override
    public List<Clazz> list() {
        return clazzMapper.list1();

    }


}
