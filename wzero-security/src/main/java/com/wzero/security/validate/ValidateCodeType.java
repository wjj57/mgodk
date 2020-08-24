package com.wzero.security.validate;

/**
 * @ClassName ValidateCodeType
 * @Description 验证码 格式
 * @Version 1.0
 */
public enum ValidateCodeType {
    SMS {
        @Override
        public String getValidateCodeTypeName() {
            return "smsCode";
        }
    },
    IMAGE {
        @Override
        public String getValidateCodeTypeName() {
            return "imageCode";
        }
    },
    ;

    ValidateCodeType() {}

    public abstract String getValidateCodeTypeName();
}
