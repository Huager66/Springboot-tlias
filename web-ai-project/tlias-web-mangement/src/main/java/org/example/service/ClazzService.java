package org.example.service;


import com.baomidou.mybatisplus.extension.service.IService;
import org.example.Clazz;
import org.example.ClazzQueryParam;
import org.example.PageResult;


import java.util.List;


public interface ClazzService extends IService<Clazz> {
    PageResult<Clazz> page(ClazzQueryParam clazzQueryParam);

    void update(Clazz clazz);
}
