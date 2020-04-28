package com.chy.whenyoufree;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.baomidou.mybatisplus.samples.quickstart.mapper")
@MapperScan("com.chy.whenyoufree.mapper")
public class WhenyoufreeApplication {

    public static void main(String[] args) {
        SpringApplication.run(WhenyoufreeApplication.class, args);
    }

}
