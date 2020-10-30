package com.maven.web.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName DataGridResult
 * @Description 响应数据结构 网状表格分页
 * @Author WJJ
 * @Date 2020/09/07 15:47
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataGridResult<T> implements Serializable {
    private static final long serialVersionUID = -78924080675043L;

    /** 总行数 */
    private long total;

    /** 页面数据 */
    private List<T> rows;
}
