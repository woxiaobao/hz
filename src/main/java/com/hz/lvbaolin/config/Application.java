package com.hz.lvbaolin.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * Created by LVBAOLIN on 2016/10/19.
 *
 * @SpringBootApplication(scanBasePackages= "com")
 * 加载springboot和扫描所有的类自动注入
 *
 * @EnableScheduling 注解，启用定时任务的配置
 *
 * @EnableAsync 异步调用配置
 *
 */
@Configuration
@SpringBootApplication(scanBasePackages= "com")
//@EnableAspectJAutoProxy
@EnableAutoConfiguration
@EnableScheduling
@EnableAsync
@EntityScan(basePackages="com.hz.lvbaolin.domain")
@EnableJpaRepositories(basePackages="com.hz.lvbaolin")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

