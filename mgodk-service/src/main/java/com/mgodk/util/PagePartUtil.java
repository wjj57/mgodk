package com.mgodk.util;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mgodk.entity.common.DataGridResult;

import java.util.List;

public abstract class PagePartUtil<T> {
    public DataGridResult getPageList(T t, Integer page, Integer rows) throws Exception {
        // 设置分页信息
        PageHelper.startPage(page, rows);
        List<T> list = getList(t);
        // 取查询结果
        PageInfo<T> pageInfo = new PageInfo<>(list);
        DataGridResult result = new DataGridResult();
        result.setTotal(pageInfo.getTotal());
        // 转换数据字典
        result.setRows(list);
        return result;
    }

    public abstract List<T> getList(T t);
}
