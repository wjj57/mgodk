package com.maven.web.entity.basevo;

import javax.persistence.Transient;
import java.io.Serializable;

/**
 * @ClassName PageVo
 * @Description 公共部分属性之分页信息
 * @Author WJJ
 * @Date 2020/09/07 15:28
 * @Version 1.0
 */
public class PageVo implements Serializable,Cloneable {
    private static final long serialVersionUID = -5573L;

    /** 第几页 */
    @Transient
    private Integer pageNumber;

    /** 每页行数 */
    @Transient
    private Integer pageSize;


    public Integer getPageNumber() {
        return pageNumber;
    }
    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }
    public Integer getPageSize() {
        return pageSize;
    }
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
