package com.mgodk.web.controller;

import com.mgodk.api.common.ReturnResult;
import com.mgodk.api.pojo.SysUser;
import com.mgodk.biz.mapper.SysUserMapper;
import com.mgodk.biz.service.SysUserService;
import com.mgodk.web.core.common.Constant;
import com.mgodk.web.core.security.PasswordEncoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import java.util.Objects;

/**
 * @ClassName LoginController
 * @Description 登录、登出 模块管理
 * @Author WJJ
 * @Date 2020/12/08 10:43
 * @Version 1.0
 * add/save,del/remove,edit/modify,get/find - batch/count/one/list/all/page/by
 */
@Controller
@Slf4j
public class LoginController {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private SysUserMapper sysUserMapper;

    /** 登录认证 */
    @PostMapping("/authentication/form")
    public String login(@RequestParam("username") String loginName, @RequestParam("password") String password, String remember,
                        Map<String,Object> map, HttpSession session,
                        HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.debug("Controller层 》 debug");
        log.info("Controller层 》 info");
        log.warn("Controller层 》 warn");
        log.error("Controller层 》 error");

        if (!StringUtils.isEmpty(loginName) && !StringUtils.isEmpty(password)) {
            SysUser sysUser = sysUserService.findSysUserByLoginName(loginName);
            if (!Objects.isNull(sysUser) && passwordEncoder.matches(password,sysUser.getPassword())) {
                session.setAttribute(Constant.SESSION_USER_INFO,sysUser);
                return "redirect:/index";
            }
            map.put("msg","账户或密码错误");
            return "login";
        }
        map.put("msg","账户或密码不能为空");
        return "login";
    }

    /** 注册账户 */
    @PostMapping("/authentication/register")
    public String register(@RequestParam("username") String loginName, @RequestParam("password") String password, @RequestParam("verPassword") String verPassword,
                           Map<String,Object> map, HttpSession session) throws Exception {
        if (!StringUtils.isEmpty(loginName) && !StringUtils.isEmpty(password)) {
            if (verPassword.equals(password)) {
                SysUser sysUser = new SysUser();
                sysUser.setLoginName(loginName);
                sysUser.setPassword(passwordEncoder.encode(password));
                int result = sysUserService.saveSysUser(sysUser);
                if (result > 0) {
                    session.setAttribute(Constant.SESSION_USER_INFO,sysUser);
                    return "redirect:/index";
                }
                map.put("msg","注册失败");
                return "login";
            }
            map.put("msg","两次密码不一致");
            return "login";
        }
        map.put("msg","账户或密码不能为空");
        return "login";
    }


    /** 图片验证码 */
    @RequestMapping("/verifyImage")
    public void toImageCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        ImageCodeUtil imageCodeUtil = new ImageCodeUtil();
//        ImageCode imageCode = imageCodeUtil.getRandomImage(80,40,4,20,30);
        //Graphics
        BufferedImage image = null;

        //方法一: 将图片传到前端页面
        //io流
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        //写入流中 png为背景透明；
        ImageIO.write(image,"jpg",baos);
        //转换成字节
        byte[] bytes = baos.toByteArray();
        BASE64Encoder encoder = new BASE64Encoder();
        //转换成base64串
        String jpg_base64 = encoder.encodeBuffer(bytes);
        //删除 \r\n
        jpg_base64 = jpg_base64.replaceAll("\n", "").replaceAll("\r", "");
        request.getSession().setAttribute("checkVerifyCode","1234");
        response.getWriter().write(jpg_base64);

        //方法二: 将图片传到前端页面
//        request.getSession().setAttribute("checkVerifyCode",imageCode.getCode());
//        //response.setContentType("image/jpeg");
//        ServletOutputStream outputStream = response.getOutputStream();
//        ImageIO.write(image,"jpg",outputStream);
//        //outputStream.flush();
    }
}
