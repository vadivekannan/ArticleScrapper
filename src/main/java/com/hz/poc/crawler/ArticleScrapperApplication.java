package com.hz.poc.crawler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * ArticleScrapperApplication intial entry
 * 
 * @author vadivel
 * @version 1.0
 * @since 07/01/2019
 *
 */

@SpringBootApplication
@EnableScheduling
public class ArticleScrapperApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArticleScrapperApplication.class, args);
	}

}
