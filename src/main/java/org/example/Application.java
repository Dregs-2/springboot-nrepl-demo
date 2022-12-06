
package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//不一定是web项目，拿web项目举🌰
//可以下载支持nrepl协议的相关命令行工具，最简单的集成可以在IDEA下载 Cursive 插件
//在启动参数中配置启动的临时变量开启功能和修改配置
//NREPL_ENABLE=true 为true时开启功能，默认false
//NREPL_PORT=7999 开放连接的端口 默认7999
//NREPL_NS=user 默认的namespace，默认是user

@SpringBootApplication(scanBasePackages = {"debug"})
//可以通过修改源码改变包名，改成和项目域名相同的就不需要显示引入，完全通过启动的环境变量来控制
@RestController
public class Application {

    /*
      🌰 安装插件后成功运行会出现repl的会话框，在里面输入下方代码回车测试效果
      (def app (bean> "application")) ;通过内置方法获取springcontext托管的类，默认是类名首字母小写，也可以根据类获取
      (.inc app 1) ;调用其中的方法
    */

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @GetMapping("/{x}")
    public int test(@PathVariable("x")int x){
        return inc(x);
    }

    public int inc(int x){
        return ++x;
    }



}
