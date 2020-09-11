package com.mgodk.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

/**
 * @ClassName ImageController
 * @Description
 * @Author WJJ
 * @Date 2020/09/07 17:50
 * @Version 1.0
 */
@Controller
public class ImageController {

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
