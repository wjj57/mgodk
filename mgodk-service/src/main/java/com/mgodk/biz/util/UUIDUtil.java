package com.mgodk.biz.util;

import java.util.UUID;

/**
 * @ClassName UUIDUtil
 * @Description UUID 编码 获取唯一字符串
 * @Author WJJ
 * @Date 2020/09/07 15:47
 * @Version 1.0
 */
public class UUIDUtil {
	/** 获取32位 UUID 编码 */
	public static String uuid() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
