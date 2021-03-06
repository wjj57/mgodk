package com.maven.web.common;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName DataGridResult
 * @Description 响应数据结构 网状表格分页
 * @Author WJJ
 * @Date 2020/09/07 15:47
 * @Version 1.0
 */
public class DataGridResult<T> implements Serializable {
    private static final long serialVersionUID = -78924080675043L;

    /** 总行数 */
    private long total;

    /** 页面数据 */
    private List<T> rows;


    public DataGridResult() {
    }
    public DataGridResult(long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }
    public long getTotal() {
        return total;
    }
    public void setTotal(long total) {
        this.total = total;
    }
    public List<T> getRows() {
        return rows;
    }
    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
