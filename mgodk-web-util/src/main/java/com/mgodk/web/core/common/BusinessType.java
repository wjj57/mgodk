package com.mgodk.web.core.common;

/**
 * @ClassName BusinessType
 * @Description 业务类型
 * @Author WJJ
 * @Date 2020/12/22 11:26
 * @Version 1.0
 */
public enum BusinessType {
    /** 其它 */
    OTHER,
    /** 增加 */
    INSERT,
    /** 修改 */
    UPDATE,
    /** 删除 */
    DELETE,
    /** 查询 */
    SELECT,
    /** 导入 */
    IMPORT,
    /** 导出 */
    EXPORT,

    /** 授权 */
    GRANT,
    /** 清空 */
    CLEAN,
    ;
}
