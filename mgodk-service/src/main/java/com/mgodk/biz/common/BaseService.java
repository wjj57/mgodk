package com.mgodk.biz.common;

import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @ClassName BaseService
 * @Description 通用 Mapper 实现 通用 Service 层业务管理
 * @Author WJJ
 * @Date 2020/11/19 15:50
 * @Version 1.0
 */
public abstract class BaseService<T> {
    @Autowired
    private Mapper<T> mapper;

    public int saveSimple(T t) throws Exception {
        return mapper.insert(t);
    }

    public int removeSimple(T t) throws Exception {
        return mapper.delete(t);
    }

    public int editSimple(T t) throws Exception {
        return mapper.updateByPrimaryKey(t);
    }

    public List<T> searchSimple(T t) throws Exception {
        return mapper.select(t);
    }
}
