package com.maven.web.core.base;

import com.github.abel533.mapper.Mapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maven.web.common.DataGridResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassName BaseMapperService
 * @Description 通用 Mapper 的 Service 使用
 * @Author WJJ
 * @Date 2020/11/10 16:02
 * @Version 1.0
 */
public abstract class BaseMapperService<T> {
    @Autowired
    private Mapper<T> mapper;

    /** 对数据进行分页显示 */
    public DataGridResult getPageList(T t, Integer page, Integer rows) throws Exception {
        // 设置分页信息
        PageHelper.startPage(page, rows);
        List<T> list = search(t);
        // 取查询结果
        PageInfo<T> pageInfo = new PageInfo<>(list);
        //封装结果对象数据
        return new DataGridResult<T>(pageInfo.getTotal(),pageInfo.getList());
    }

    public int save(T t) throws Exception {
        return mapper.insert(t);
    }

    public int remove(T t) throws Exception {
        return mapper.delete(t);
    }

    public int edit(T t) throws Exception {
        return mapper.updateByPrimaryKey(t);
    }

    public List<T> search(T t) throws Exception {
        return mapper.select(t);
    }
}
