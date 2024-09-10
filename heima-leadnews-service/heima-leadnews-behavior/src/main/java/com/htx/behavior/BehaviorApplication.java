package com.htx.behavior;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/9/10 21:46
 */
@SpringBootApplication
@EnableDiscoveryClient
public class BehaviorApplication {

    public static void main(String[] args) {
        SpringApplication.run(BehaviorApplication.class,args);
    }
}
