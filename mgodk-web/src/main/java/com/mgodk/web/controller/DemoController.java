package com.mgodk.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName DemoController
 * @Description 测试
 * @Author WJJ
 * @Date 2020/10/26 11:44
 * @Version 1.0
 */
@RequestMapping(value = "/do")
@RestController
public class DemoController {
    @RequestMapping(value = "/demo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> demo() throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
