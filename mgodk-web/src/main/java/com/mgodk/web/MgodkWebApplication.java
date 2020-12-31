package com.mgodk.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Package com.mgodk.web
 * @ClassName MgodkWebApplication
 * @Description 启动类
 * @Author WJJ
 * @Date 2020/7/15 10:06
 * @Version 1.0
 */
@EnableTransactionManagement //开启 事务管理
@MapperScan("com.mgodk.biz.mapper") //扫描 mapper 接口，生成实现类及注入容器中（在非主程序下的包不能使用 @Mapper）
@ComponentScan({"com.mgodk.biz","com.mgodk.web"}) //扫描 @Repository @Service @Controller @Component 等组件到容器中
@SpringBootApplication
public class MgodkWebApplication {
    private static Logger logger = LoggerFactory.getLogger(MgodkWebApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MgodkWebApplication.class,args);
        System.out.println(print());
        logger.info("MgodkWebApplication ===》 启动成功");
    }

    private static String print() {
        StringBuffer sb = new StringBuffer();
        sb.append("                   _ooOoo_\n");
        sb.append("                  o8888888o\n");
        sb.append("                  88\" . \"88\n");
        sb.append("                  (| ^_^ |)\n");
        sb.append("                  O\\  =  /O\n");
        sb.append("               ____/`---'\\____\n");
        sb.append("             .'  \\\\|     |//  `.\n");
        sb.append("            /  \\\\|||  :  |||//  \\ \n");
        sb.append("           /  _||||| -:- |||||-  \\ \n");
        sb.append("           |   | \\\\\\  -  /// |   |\n");
        sb.append("           | \\_|  ''\\---/''  |   |\n");
        sb.append("           \\  .-\\__  `-`  ___/-. /\n");
        sb.append("         ___`. .'  /--.--\\  `. . __\n");
        sb.append("      .\"\" '<  `.___\\_<|>_/___.'  >'\"\".\n");
        sb.append("     | | :  `- \\`.;`\\ _ /`;.`/ - ` : | |\n");
        sb.append("     \\  \\ `-.   \\_ __\\ /__ _/   .-` /  /\n");
        sb.append("======`-.____`-.___\\_____/___.-`____.-'======\n");
        sb.append("                   `=---='\n");
        sb.append("...................................................\n");
        return sb.toString();
    }

    private static String printDog() {
        StringBuffer sb = new StringBuffer();
        sb.append("                                                  \n");
        sb.append("            ___       ___                         \n");
        sb.append("           /  /      /  /                         \n");
        sb.append("        ___/  /______/  /___                      \n");
        sb.append("       /        ___        /                      \n");
        sb.append("       /                   /                      \n");
        sb.append("       /   ____/   /____   /                      \n");
        sb.append("       /    /         /    /                      \n");
        sb.append("       /         /         /                      \n");
        sb.append("       /        ~~         /                      \n");
        sb.append("       /______       ______/                      \n");
        sb.append("             /      /                             \n");
        sb.append("            /      /________________              \n");
        sb.append("            /                      /              \n");
        sb.append("            /                      /____          \n");
        sb.append("            /                      /   /          \n");
        sb.append("            /                      /___/          \n");
        sb.append("            /______________________/              \n");
        sb.append("               / / /        / / /                 \n");
        sb.append("               /_/_/        /_/_/                 \n");
        sb.append("                                                  \n");
        sb.append("..................................................\n");
        return sb.toString();
    }
}