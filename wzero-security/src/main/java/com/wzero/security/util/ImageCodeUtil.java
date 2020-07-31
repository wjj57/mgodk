package com.wzero.security.util;

import com.wzero.security.validate.image.ImageCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.Random;

/**
 * @ClassName ImageCodeUtil
 * @Description 图片验证码 生成工具
 * @Author WJJ
 * @Date 2020/7/30 17:55
 * @Version 1.0
 */
public class ImageCodeUtil {
    private static Logger logger = LoggerFactory.getLogger(ImageCodeUtil.class);

    /** 获取随机数对象 */
    private static Random random = new Random();
    /** 字符串随机生成 验证码; 0123456789 abcdefghijklmnopqrstuvwxyz ABCDEFGHIJKLMNOPQRSTUVWXYZ */
    private static String codes = "0123456789abcdefghijklmnopqrstuvwxyz";
    /** 字体样式 */
    private static String[] fontNames = {"Fixedsys","Times New Roman","宋体","华文楷体","黑体","微软雅黑","楷体_GB2312"};
    /** 默认图片宽度 */
    private static int defaultWidth = 80;
    /** 默认图片高度 */
    private static int defaultHeight = 40;
    /** 默认验证码字符串长度 */
    private static int defaultCodeNum = 4;
    /** 默认干扰线数 */
    private static int defaulLineNum = 30;
    /** 默认干扰线数 */
    private static int defaulFontSize = 30;
    /** 随机字体基本大小 */
    private static int fontBaseSize = 20;
    /** 随机字体大小变化范围 */
    private static int fontRandSize = 10;

    /** 获得随机字体样式 */
    private static Font randomFont() {
        int index = random.nextInt(fontNames.length);
        //随机字体
        String fontName = fontNames[index];
        //随机字体样式；0无样式，1加粗，2斜体，3斜体加粗；
        int style = random.nextInt(4);
        //随机字体大小
        int size = random.nextInt(fontRandSize) + fontBaseSize;
        return new Font(fontName,style,size);
    }
    private static Font randomFont(int fontSize) {
        int index = random.nextInt(fontNames.length);
        //随机字体
        String fontName = fontNames[index];
        //随机字体样式；0无样式，1加粗，2斜体，3斜体加粗；
        int style = random.nextInt(4);
        //随机字体大小
        return new Font(fontName,style,fontSize);
    }

    /** 获得随机颜色 */
    private static Color randomColor() {
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);
        return new Color(r,g,b);
    }

    /** 获取随机字符串 */
    private static String randomString() {
        int index = random.nextInt(codes.length());
        return String.valueOf(codes.charAt(index));
    }

    /** 创建图片、绘制干扰线、设置字体 */
    private static ImageCode createImage(int width, int height, int codeNum, int lineNum, Font font) {
        //创建Image类的缓冲区；Image类是用于描述图像信息的类;   宽度、高度、背景颜色类型1~13
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);
        //获取画笔，Graphics对象可以在图像上进行各种绘制操作
        Graphics graphics = image.getGraphics();
        //图片大小
        graphics.fillRect(0,0,width,height);
        //图片随机背景颜色
        graphics.setColor(randomColor());
        //绘制干扰线
        for (int i = 0; i < lineNum; i++) {
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int x2 = random.nextInt(width);
            int y2 = random.nextInt(height);
            graphics.setColor(randomColor());
            graphics.drawLine(x1,y1,x2,y2);
        }
        //绘制随机字符
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < codeNum; i++) {
            //字体样式
            graphics.setFont(font);
            //字体颜色
            graphics.setColor(randomColor());
            //获取随机字符串
            String str = randomString();
            stringBuffer.append(str);
            //填充字符串、坐标位置
            graphics.drawString(str,i*defaultWidth/defaultCodeNum,2*defaultHeight/3);
        }
        logger.info("图片验证码 ：" + stringBuffer.toString());
        return new ImageCode(stringBuffer.toString(),image);
    }


    /** 生成随机图片验证码 width图片宽度，height图片高度，codeNum验证码数量 */
    public static ImageCode getRandomImageDefault() {
        return createImage(defaultWidth,defaultHeight,defaultCodeNum,defaulLineNum,randomFont(defaulFontSize));
    }
    public static ImageCode getRandomImage() {
        return createImage(defaultWidth,defaultHeight,defaultCodeNum,random.nextInt(defaulLineNum),randomFont());
    }
    public static ImageCode getRandomImage(int width, int height, int codeNum) {
        return createImage(width,height,codeNum,defaulLineNum,randomFont());
    }
    public static ImageCode getRandomImage(int width, int height, int codeNum, Font font) {
        return createImage(width,height,codeNum,defaulLineNum,font);
    }
    public static ImageCode getRandomImage(int width, int height, int codeNum, int lineNum) {
        return createImage(width,height,codeNum,lineNum,randomFont());
    }
    public static ImageCode getRandomImage(int width, int height, int codeNum, int lineNum, int fontSize) {
        return createImage(width,height,codeNum,lineNum,randomFont(fontSize));
    }
    public static ImageCode getRandomImage(int width, int height, int codeNum, int lineNum, Font font) {
        return createImage(width,height,codeNum,lineNum,font);
    }

    /** 将生成的验证码图片输出，并指定输出图片格式 */
    public static void outPutImage(BufferedImage image, OutputStream outputStream) throws Exception {
        ImageIO.write(image,"JPEG",outputStream);
    }
}
