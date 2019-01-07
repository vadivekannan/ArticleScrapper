package com.hz.poc.crawler.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hz.poc.crawler.engine.CrawlerData;
import com.hz.poc.crawler.engine.CrawlerEngine;

/**
 * CrawlerScheduler runs daily night to crawl the pages
 * 
 * @author vadivel
 * @version 1.0
 * @since 07/01/2019
 *
 */

@Component
public class CrawlerScheduler {
	private static final Logger logger = LoggerFactory.getLogger(CrawlerScheduler.class);
	private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

	@Scheduled(cron = "0 0 12 1/1 * ?*") // Runs Daily 12 PM
//	@Scheduled(fixedDelay = 2000)

	// Scheduler thread job crawls hindu website daily 12pm
	public void newsCrawler() {
		logger.info("Crawler Scheduler begins on - {}", dateTimeFormatter.format(LocalDateTime.now()));
		CrawlerData data = new CrawlerData("https://thehindu.com/archive");
		Thread scrapper = new CrawlerEngine(data);
		scrapper.start();
	}

}
