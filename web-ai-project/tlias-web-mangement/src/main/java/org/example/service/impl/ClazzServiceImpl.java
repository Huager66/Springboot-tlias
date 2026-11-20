package org.example.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class ClazzServiceImpl extends ServiceImpl<ClazzMapper, Clazz> implements ClazzService {
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
    public void update(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        lambdaUpdate()
                .set(Clazz::getUpdateTime, LocalDateTime.now())
                .set(clazz.getName() != null && !clazz.getName().isEmpty(), Clazz::getName, clazz.getName())
                .set(clazz.getRoom() != null && !clazz.getRoom().isEmpty(), Clazz::getRoom, clazz.getRoom())
                .set(clazz.getBeginDate() != null, Clazz::getBeginDate, clazz.getBeginDate())
                .set(clazz.getEndDate() != null, Clazz::getEndDate, clazz.getEndDate())
                .set(clazz.getMasterId() != null, Clazz::getMasterId, clazz.getMasterId())
                .set(clazz.getSubject() != null, Clazz::getSubject, clazz.getSubject())
                .eq(Clazz::getId, clazz.getId())
                .update();
    }
}
