package com.wzero.security.model;

public interface IResponse {
    /** 返回编码 */
    String getCode();

    /** 返回消息 */
    String getMessage();

    /** 返回标识符 */
    String getMark();
}
