package com.example;

import com.example.config.CustomListenerConfig;
import com.example.config.CustomMsg;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MapperScan(basePackages = {"com.example.mapper"})
@ServletComponentScan(basePackages = {"com.example.config"})
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(DemoApplication.class, args);
		run.addApplicationListener(new CustomListenerConfig());
		CustomMsg customMsg = new CustomMsg("哈哈");
		customMsg.sendMsg("消息实体");
		run.publishEvent(customMsg);
	}

}
