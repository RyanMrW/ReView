package com.ryan.review;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.ryan.review.mapper")
@SpringBootApplication
public class ReviewApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(ReviewApplication.class);
		application.setBannerMode(Banner.Mode.OFF);
		application.run(args);
	}

}
