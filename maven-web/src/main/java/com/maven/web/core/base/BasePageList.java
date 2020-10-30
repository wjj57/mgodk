package com.maven.web.core.base;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maven.web.common.DataGridResult;

import java.util.List;

/**
 * @ClassName BasePageList
 * @Description 通用分页操作方法
 * @Author WJJ
 * @Date 2020/10/19 11:00
 * @Version 1.0
 */
public abstract class BasePageList<T> {
    /** 对数据进行分页显示 */
    public DataGridResult getPageList(T t, Integer page, Integer rows) throws Exception {
        // 设置分页信息
        PageHelper.startPage(page, rows);
        List<T> list = getList(t);
        // 取查询结果
        PageInfo<T> pageInfo = new PageInfo<>(list);
        //封装结果对象数据
        //DataGridResult result = new DataGridResult();
        //result.setTotal(pageInfo.getTotal());
        //result.setRows(list);
        return new DataGridResult<T>(pageInfo.getTotal(),list);
    }

    /** 获取数据 */
    public abstract List<T> getList(T t);
}
