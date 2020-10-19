package com.mgodk.api.basevo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Transient;
import java.io.Serializable;

/**
 * @ClassName PageVo
 * @Description 公共部分属性之分页信息
 * @Author WJJ
 * @Date 2020/09/07 15:28
 * @Version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PageVo implements Serializable,Cloneable {
    private static final long serialVersionUID = -5573L;

    /** 第几页 */
    @Transient
    private Integer pageNumber;

    /** 每页行数 */
    @Transient
    private Integer pageSize;
}
