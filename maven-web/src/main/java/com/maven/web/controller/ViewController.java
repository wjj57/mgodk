package com.maven.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName ViewController
 * @Description 前后端分离，返回页面
 * @Author WJJ
 * @Date 2020/11/10 17:22
 * @Version 1.0
 */
@Controller
@RequestMapping("/view")
public class ViewController {
    @RequestMapping(value = "/index")
    public String toPageIndex() throws Exception {
        return "index";
    }

}
