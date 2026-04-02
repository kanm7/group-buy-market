package cn.bugstack;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@Configurable
@EnableScheduling // 必须要有这个注解，项目才支持定时任务，否则即使写了定时任务，也不会执行
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class);
    }

}
