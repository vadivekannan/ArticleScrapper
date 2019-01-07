package com.hz.poc.crawler.engine;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.stereotype.Component;

/**
 * CrawlerData acts data container
 * 
 * @author vadivel
 * @version 1.0
 * @since 07/01/2019
 *
 */
@Component
public class CrawlerData {

	// Queue to store URL's
	private ConcurrentLinkedQueue<String> urlQueue = new ConcurrentLinkedQueue<String>();

	// ArrayList of visited URL's
	private ArrayList<String> archivedURL = new ArrayList<String>();

	public CrawlerData(String initial_url) {
		urlQueue.offer(initial_url);
	}

	public CrawlerData() {
	}

	// add URL in to queue
	public void addURL(String url) {
		urlQueue.offer(url);
	}

	// Get URL at front of queue
	public String getURL() {
		return urlQueue.poll();
	}

	// URLs size
	public int urlQueueSize() {
		return urlQueue.size();
	}

	// Add visited URL
	public void addArchivedURL(String url) {
		archivedURL.add(url);
	}

	public ArrayList<String> getExtractedURLs() {
		return archivedURL;
	}

	// Checks if link has already been visited
	public boolean existingLink(String link) {
		for (String url : archivedURL) {
			if (url.equals(link)) {
				return true;
			}
		}
		return false;
	}
}
