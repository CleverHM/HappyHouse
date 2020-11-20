package com.ssafy.happyhouse.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(
		basePackages = "com.ssafy.happyhouse.dao"
)
// 이게 있으면 DAO에 인터페이스들에 매번  mapper를 붙이지 않아도 된다.
public class DatabaseConfig {}