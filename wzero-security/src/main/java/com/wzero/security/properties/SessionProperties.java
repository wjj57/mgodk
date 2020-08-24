package com.wzero.security.properties;

import com.wzero.security.model.CommonConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ClassName SessionProperties
 * @Description 自定义 Session会话 属性文件
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SessionProperties {
    /** 会话 最大值 */
    private int maximumSessions = 1;
    /** 限制登录 */
    private boolean preventsLogin = false;
    /** 会话 失效路径 */
    private String sessionInvalidUrl = CommonConstants.DEFAULT_SESSION_INVALID_URL;

}
